import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Drawer from '@material-ui/core/Drawer';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import { Typography } from '@material-ui/core';
import { ReactComponent as Send } from '../../../assets/Icons/send.svg';
import { ReactComponent as Resend } from '../../../assets/Icons/resend.svg';
import { ReactComponent as SendDull } from '../../../assets/Icons/sendDull.svg';
import { ReactComponent as Message } from '../../../assets/Icons/sms.svg';
import { ReactComponent as Mail } from '../../../assets/Icons/mail.svg';
import { useHistory } from "react-router-dom";
import KLSnackBar from '../../atoms/KLSnackBar/KLSnackBar';
import KLButton from '../../atoms/KLButton/KLButton';
import adminData from '../../../AdminExternalization.json';

const useStyles = makeStyles({
  fullList: {
    width: 'auto',
    height: '263'
  },
  bodyTextStyle: {
    height: 32,
    color: '#344563',
    fontFamily: 'Roboto Condensed',
    fontSize: 12,
    fontWeight: 'bold',
    letterSpacing: 0,
    lineHeight: 2.5,
  },
  headingTextStyle: {
    height: 32,
    color: '#344563',
    fontFamily: "Roboto Condensed",
    fontSize: 16,
    fontWeight: "bold",
    letterSpacing: 0,
    lineHeight: 3,
  },
  buttonDivStyle: {
    textAlign: 'center',
    margin:'0px 10px 10px 10px'
  },
  listItemIconStyle: {
    width: 30,
    minWidth: 30
  },
  largeIconStyle: {
    width: 50,
    minWidth: 50
  }
});

function DrawerComponent
  (props) {
  const classes = useStyles();
  const [resend, setResend] = React.useState(false);
  const [resendMobile, setResendMobile] = React.useState(false);
  const [open, setOpen] = React.useState(false);
  const history = useHistory();


  const toggleDrawer = (event) => {
    if (event.type === 'keydown' && (event.key === 'Tab' || event.key === 'Shift')) {
      return;
    }
    props.onClose()
    setResend(false)
    setResendMobile(false)
  };

  const handleresendMobile = () => {
    setResendMobile(true)
  };

  const handleresend = () => {
    setResend(true)
  };

  const handleClick = () => {
    setOpen(true)
  };

  const handleButtonClose = () => {
    props.onClose()
    setResend(false)
    setResendMobile(false)
    history.push("/newLink")
  };

  const list = () => (
    <div
      className={classes.fullList}
      role="presentation"
    >
      <List>
        <Typography
          className={classes.headingTextStyle}
          variant='h5'
          align='center'
        >
          {adminData.shareScreen.info}
        </Typography>
        {adminData.shareScreen.content.map((text, index) => (
          <ListItem key={text}>
            <ListItemIcon
              className={classes.listItemIconStyle}
            >
              {index % 2 === 0 ? <Message /> : <Mail />}
            </ListItemIcon>
            <ListItemText
              classes={{ primary: classes.bodyTextStyle }}
              primary={text}
            />
            <ListItemIcon
              style={{ cursor: "pointer" }}
              className={classes.largeIconStyle}
            >
              {index % 2 === 0 ?
                props.disable ?
                  resendMobile ? <Resend />
                    : <Send onClick={handleresendMobile} />
                  : <SendDull onClick={handleClick} />
                : resend ? <Resend /> : <Send onClick={handleresend} />}
            </ListItemIcon>
          </ListItem>
        ))}
      </List>
      <div className={classes.buttonDivStyle}>
        <KLButton
          disabled={!resend && !resendMobile}
          value={adminData.shareScreen.button}
          onClick={handleButtonClose}
        />
      </div>
    </div>
  );

  return (
    <div>
      {
        <React.Fragment >
          <Drawer
            anchor={'bottom'}
            open={props.open}
            onClose={toggleDrawer}
          >
            {list()}
          </Drawer>

          <KLSnackBar
            open={open}
            message={adminData.shareScreen.popupMsg}
            onClose={() => { setOpen(false) }}
          />
        </React.Fragment>
      }
    </div>
  );
}
export default DrawerComponent;