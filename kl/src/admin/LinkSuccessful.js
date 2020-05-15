import React from 'react'
import { Grid } from '@material-ui/core';
import { makeStyles } from '@material-ui/core'
import { Typography } from '@material-ui/core';
import Box from '@material-ui/core/Box';
import successfulImg from '../assets/Images/Link successful.png'
import { useHistory } from "react-router-dom"
import logo from '../assets/Logo/kind-linen-logo.svg'
import KLButton from '../_components/atoms/KLButton/KLButton';
import adminData from '../AdminExternalization.json';

const useStyles = makeStyles({
    root: {
        maxWidth: '350px'
    },
    typography: {
        color: '#344563',
        fontFamily: 'Roboto Condensed',
        fontSize: 16,
        letterSpacing: 0,
        textAlign: 'center',
        fontWeight: 700
    },
    buttonStyle: {
        height: 50,
        width: 332,
    }
});

function LinkSuccessful(props) {
    const classes = useStyles();
    const history = useHistory();

    const handleClick = () => {
        history.push("/")
    }
    return (

        <form onSubmit={handleClick}
            center="true" align="center" fullWidth>

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
                                <Grid container justify={"center"} alignItems={"center"} style={{ height: '184px' }}>
                                    <Grid item >
                                        <img className="img-fluid" src={successfulImg} alt="success" />
                                    </Grid>
                                </Grid>
                            </Grid>
                            <Grid item xs={12}>
                                <Grid container justify={"center"} alignItems={"center"} style={{ height: '100px' }}>
                                    <Grid item >
                                        <Typography className={classes.typography} center="true" >
                                            {adminData.linkSuccessful.info}
                                        </Typography>
                                    </Grid></Grid></Grid>

                            <Grid item xs={12}>
                                <Grid container justify={"center"} alignItems={"center"} style={{ height: '30px' }}>
                                    <Grid item xs={12}>
                                        <KLButton value={adminData.linkSuccessful.button} onClick={handleClick} />
                                    </Grid></Grid></Grid>
                        </Grid>
                    </Grid>
                </Grid>
            </Box>
        </form>
    );
}

export default LinkSuccessful