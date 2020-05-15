import React from 'react'
import { Grid } from '@material-ui/core';
import { makeStyles } from '@material-ui/core'
import { Typography } from '@material-ui/core';
import Box from "@material-ui/core/Box"
import { Media } from 'react-breakpoints'
import DrawerComponent from '../_components/molecules/KLDrawer/KLDrawer';
import InputTextOutline from '../_components/molecules/KLTextFieldOutlined/KLTextFieldOutlined'
import KLButton from '../_components/atoms/KLButton/KLButton';
import DraggableDialogComponent from '../_components/molecules/KLDraggableDialog/KLDraggableDialog';
import logo from '../assets/Logo/kind-linen-logo.svg'
import BackButton from '../assets/Icons/BackButton.svg'
import adminData from '../AdminExternalization.json'

const useStyles = makeStyles({
    root: {
        maxWidth: '350px'
    },
    typography: {
        color: '#344563',
        fontFamily: 'Roboto Condensed',
        fontSize: 16,
        fontWeight:'bold',
        letterSpacing: 0,
        textAlign: 'center'
    },
    buttonStyle: {
        height: 50,
        width: 332,
    }
});

function LinkCopyAndShare(props) {
    const classes = useStyles();
    const [open, setOpen] = React.useState(false)

    const handleBack = () => {
        props.history.push("/")
    }


    return (
        <Box display="flex" justifyContent="center" bgcolor="background.paper">

            <Grid conatiner className={classes.root}>
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
                            <Grid container justify={"center"} alignItems={"center"} style={{ height: '50px' }}>
                                <Grid item >
                                    <Typography className={classes.typography} center="true" >
                                        {adminData.linkCpoyAndShare.info}
                                     </Typography>
                                </Grid>
                            </Grid>
                        </Grid>
                        <Grid item xs={12}>
                            <Grid container justify={"center"} alignItems={"center"} style={{ height: '51px' }}>
                                <Grid item xs={11}>
                                    <InputTextOutline  value={props.location.state.retrievedData+props.location.state.orgName} />
                                </Grid>
                            </Grid>
                        </Grid>
                        <Grid item xs={11}>
                            <Grid container justify={"space-between"} alignItems={"center"} style={{ height: '100px' }}>

                                <Grid item  >
                                    <img style={{cursor:'pointer'}} src={BackButton} alt="Back Button" onClick={handleBack} />
                                </Grid>

                                <Grid item >
                                    <KLButton value={adminData.linkCpoyAndShare.buttons[1]} onClick={() => { setOpen(true) }} />
                                    <Media>
                                        {({ breakpoints, currentBreakpoint }) =>
                                            breakpoints[currentBreakpoint] >= 480 ? (
                                                <DraggableDialogComponent open={open}
                                                    onClose={() => { setOpen(false) }}
                                                    disable={props.location.state.mobileNumber === 0 ? false : true} />
                                            ) : (
                                                    <DrawerComponent
                                                        open={open}
                                                        onClose={() => { setOpen(false) }}
                                                        disable={props.location.state.mobileNumber === 0 ? false : true}
                                                    />
                                                )
                                        }
                                    </Media>
                                </Grid>

                            </Grid>

                        </Grid>

                    </Grid>
                </Grid>
            </Grid>
        </Box>

    );
}

export default LinkCopyAndShare

