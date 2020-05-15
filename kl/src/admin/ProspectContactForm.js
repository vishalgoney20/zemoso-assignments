import React from 'react'
import { Grid } from '@material-ui/core';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core'
import Box from '@material-ui/core/Box';
import logo from '../assets/Logo/kind-linen-logo.svg'
import KLTextField from '../_components/atoms/KLTextField/KLTextField';
import KLButton from '../_components/atoms/KLButton/KLButton';
import validator from 'validator';
import adminData from '../AdminExternalization.json'

const useStyles = makeStyles({
    root: {
        maxWidth: '350px'
    },
    typography: {
        color: '#344563',
        fontFamily: 'Roboto Condensed',
        fontSize: 16,
        letterSpacing: 0,
        textAlign: 'center'
    },
    Welcometypo: {
        color: '#344563',
        fontFamily: 'Roboto Condensed',
        fontSize: 24,
        letterSpacing: 0,
        textAlign: 'center',
        fontWeight: 700
    }
});

export default function ProspectContactForm(props) {
    const classes = useStyles();
    const [state, setState] = React.useState({
        OrganizationName: '',
        ContactName: '',
        MobileNumber: '',
        Email: '',
    })

    const [errorEmail, setErrorEmail] = React.useState(false);
    const [helperTextEmail, setHelperTextEmail] = React.useState('');
    const [errorPhone, setErrorPhone] = React.useState(false);
    const [helperTextPhone, setHelperTextPhone] = React.useState('')


    const handleChange = (event) => {
        setState({ ...state, [event.target.name]: event.target.value });
        if (event.target.name === 'Email') {
            if (!validator.isEmail(event.target.value)) {
                setErrorEmail(true);
                setHelperTextEmail("invalid email")
            }
            else {
                setErrorEmail(false)
                setHelperTextEmail('')
            }
        }
        if (event.target.name === 'MobileNumber') {
            if (!validator.isMobilePhone(event.target.value, 'en-IN' | 'en-US')) {
                setErrorPhone(true);
                setHelperTextPhone("invalid mobile number")
            }
            else {
                setErrorPhone(false)
                setHelperTextPhone('')
            }
        }
    }


    const mySubmit = async () => {

        await fetch('http://localhost:5000/prospectDetails', {
            method: 'POST',
            headers: {
                'content-type': 'application/json'
            },
            body: JSON.stringify({
                orgName: state.OrganizationName,
                contactName: state.contactName,
                mobileNumber: state.mobileNumber,
                email: state.email
            })
        });
        console.log("storing to json..");

        const response = await fetch('http://localhost:5000/GenerateLink/1');
        const body = await response.json();


        if (state.MobileNumber === '')
            props.history.push({ pathname: "/share", state: { mobileNumber: 0, retrievedData: body.link, orgName: state.OrganizationName } })
        else
            props.history.push({ pathname: "/share", state: { mobileNumber: state.MobileNumber, retrievedData: body.link, orgName: state.OrganizationName } });
   
    };

    return (

        <form onSubmit={event => event.preventDefault()}
            center="true" align="center" >

            <Box display="flex" justifyContent="center" bgcolor="background.paper" >

                <Grid className={classes.root} >
                    <Grid item xs={12}>
                        <Grid container justify="center">
                            <Grid item xs={12}>
                                <Grid container justify={"center"} alignItems={"center"} style={{ height: '134px' }}>
                                    <Grid item >
                                        <img className="img-fluid" src={logo} alt="Logo " />
                                    </Grid>
                                </Grid>
                            </Grid>
                            <Grid item xs={12}>
                                <Grid container justify={"center"} alignItems={"center"} style={{ height: '20px' }}>
                                    <Grid item >
                                        <Typography className={classes.Welcometypo} center="true" >
                                            {adminData.prospectContactForm.welcome}{"\n"}
                                        </Typography>
                                    </Grid></Grid></Grid>
                            <Grid item xs={12}>
                                <Grid container justify={"center"} alignItems={"center"} style={{ height: '50px' }}>
                                    <Grid item >
                                        <Typography className={classes.typography} center="true" >
                                            {adminData.prospectContactForm.info}
                                        </Typography>
                                    </Grid>
                                </Grid>
                            </Grid>

                            <Grid container justify="center" spacing={3}>
                                <Grid item xs={12}>
                                    <Grid container justify={"center"} alignItems={"center"} style={{ height: '50px' }}>

                                        <Grid item xs={12}>
                                            <KLTextField type={"text"} required={true} value={state.OrganzationName} name={"OrganizationName"} label={adminData.prospectContactForm.labels[0]} onChange={handleChange} />
                                        </Grid>
                                    </Grid>
                                </Grid>

                                <Grid item xs={12}>
                                    <Grid container justify={"center"} alignItems={"center"} style={{ height: '50px' }}>
                                        <Grid item xs={12}>
                                            <KLTextField type={"text"} required={true} value={state.ContactName} name={"ContactName"} label={adminData.prospectContactForm.labels[1]} onChange={handleChange} />
                                        </Grid>
                                    </Grid>
                                </Grid>

                                <Grid item xs={12}>
                                    <Grid container justify={"center"} alignItems={"center"} style={{ height: '50px' }}>
                                        <Grid item xs={12}>
                                            <KLTextField type={"text"} value={state.MobileNumber} name={"MobileNumber"} label={adminData.prospectContactForm.labels[2]} onChange={handleChange}
                                                error={errorPhone} helperText={helperTextPhone}
                                            />

                                        </Grid></Grid></Grid>


                                <Grid item xs={12}>
                                    <Grid container justify={"center"} alignItems={"center"} style={{ height: '50px' }}>
                                        <Grid item xs={12}>
                                            <KLTextField type={"email"} required={true} value={state.Email} name={"Email"} label={adminData.prospectContactForm.labels[3]} onChange={handleChange}
                                                error={errorEmail} helperText={helperTextEmail}
                                            />
                                        </Grid></Grid></Grid>

                                <Grid item xs={12}>
                                    <Grid container justify={"center"} alignItems={"center"} style={{ height: '75px' }}>
                                        <Grid item xs={12}>
                                            <KLButton disabled={state.OrganizationName === '' || state.Email === ''} variant="contained"
                                                color="primary" onClick={mySubmit} value={adminData.prospectContactForm.button} />

                                        </Grid></Grid></Grid>
                            </Grid>
                        </Grid>
                    </Grid>
                </Grid>
            </Box>
        </form>

    )
}


