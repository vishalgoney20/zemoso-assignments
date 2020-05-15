import React from 'react';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogTitle from '@material-ui/core/DialogTitle';
import Paper from '@material-ui/core/Paper';
import Draggable from 'react-draggable';
import { makeStyles, Grid, List, ListItem, ListItemIcon, ListItemText, Typography } from '@material-ui/core';
import { ReactComponent as Send } from '../../../assets/Icons/send.svg';
import { ReactComponent as Resend } from '../../../assets/Icons/resend.svg';
import { ReactComponent as SendDull } from '../../../assets/Icons/sendDull.svg';
import { ReactComponent as Message } from '../../../assets/Icons/sms.svg';
import { ReactComponent as Mail } from '../../../assets/Icons/mail.svg';
import IconButton from '@material-ui/core/IconButton';
import HighlightOffSharpIcon from '@material-ui/icons/HighlightOffSharp';
import { useHistory } from 'react-router-dom';
import KLButton from '../../atoms/KLButton/KLButton';
import KLSnackBar from '../../atoms/KLSnackBar/KLSnackBar';
import adminData from '../../../AdminExternalization.json';

const useStyles = makeStyles({
    textStyle: {
        height: 32,
        color: '#344563',
        fontFamily: 'Roboto Condensed',
        fontSize: 12,
        fontWeight: 'bold',
        letterSpacing: 0,
        lineHeight: 2.5,
        paddingRight: 20
    },
    headingStyle: {
        height: 32,
        color: '#344563',
        fontFamily: "Roboto Condensed",
        fontSize: 16,
        fontWeight: "bold",
        letterSpacing: 0,
        lineHeight: 3,
        textAlign: "center"
    },
    listItemIconStyle: {
        width: 30,
        minWidth: 30
    },
    largeIconStyle: {
        width: 40,
        minWidth: 40
    },
    listStyle: {
        paddingLeft: 0,
        paddingRight: 0
    }
});

function PaperComponent(props) {
    return (
        <Draggable
            handle="#draggable-dialog-title"
            cancel={'[class*="MuiDialogContent-root"]'}
        >
            <Paper {...props} />
        </Draggable>
    );
}

export default function DraggableDialogComponent(props) {
    const classes = useStyles();
    const [resendEmail, setResendEmail] = React.useState(false);
    const [resendMobile, setResendMobile] = React.useState(false);
    const [open, setOpen] = React.useState(false);
    const history = useHistory();

    const handleresendEmail = () => {
        setResendEmail(true)
    };

    const handleresendMobile = () => {
        setResendMobile(true)
    };

    const handleClick = () => {
        setOpen(true)
    };

    const handleClose = () => {
        props.onClose()
        setResendEmail(false)
        setResendMobile(false)
    };

    const handleButtonClose = () => {
        props.onClose()
        setResendEmail(false)
        setResendMobile(false)
        history.push("/newLink")
    };

    return (
        <div>
            <KLSnackBar
                open={open}
                message={adminData.shareScreen.popupMsg}
                onClose={() => { setOpen(false) }}
            />
            <Dialog
                open={props.open}
                onClose={handleClose}
                PaperComponent={PaperComponent}
                aria-labelledby="draggable-dialog-title"
            >
                <DialogTitle
                    style={{ cursor: 'move' }}
                    id="draggable-dialog-title"
                    onClose={handleClose}>
                    <Grid
                        container
                        direction={"row"}
                    >
                        <Grid
                            item
                            xs={10}
                        >
                            <Typography
                                className={classes.headingStyle}
                            >
                                {adminData.shareScreen.info}
                                </Typography>
                        </Grid>
                        <Grid item xs={2}>
                            <IconButton
                                aria-label="close"
                            >
                                <HighlightOffSharpIcon
                                    onClick={handleClose}
                                />
                            </IconButton>
                        </Grid>
                    </Grid>
                </DialogTitle>
                <DialogContent
                    style={{ paddingBottom: '0', paddingTop: '0' }}
                >
                    <List>
                        {adminData.shareScreen.content.map((text, index) => (
                            <ListItem
                                key={text}
                                className={classes.listStyle}
                            >
                                <ListItemIcon
                                    className={classes.listItemIconStyle}
                                >
                                    {index % 2 === 0 ? <Message /> : <Mail />}
                                </ListItemIcon>
                                <ListItemText
                                    classes={{ primary: classes.textStyle }}
                                    primary={text} />
                                <ListItemIcon
                                    style={{ cursor: "pointer" }}
                                    className={classes.largeIconStyle}
                                >
                                    {index % 2 === 0 ?
                                        props.disable ?
                                            resendMobile ? <Resend />
                                                : <Send onClick={handleresendMobile} />
                                            : <SendDull onClick={handleClick} />
                                        : resendEmail ? <Resend />
                                            : <Send onClick={handleresendEmail} />}
                                </ListItemIcon>
                            </ListItem>
                        ))}
                    </List>
                </DialogContent>
                <DialogActions
                    style={{ paddingBottom: '16' }}
                >
                    <KLButton
                        disabled={!resendEmail && !resendMobile}
                        value={adminData.shareScreen.button}
                        onClick={handleButtonClose}
                    />
                </DialogActions>
            </Dialog>
        </div>
    );
}
