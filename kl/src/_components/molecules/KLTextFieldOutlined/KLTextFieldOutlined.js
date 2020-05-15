import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import OutlinedInput from '@material-ui/core/OutlinedInput';
import InputAdornment from '@material-ui/core/InputAdornment';
import FormControl from '@material-ui/core/FormControl';
import {CopyToClipboard} from 'react-copy-to-clipboard';
import copyIcon from '../../../assets/Icons/copy.svg';
import KLSnackBar from '../../atoms/KLSnackBar/KLSnackBar';
import adminData from '../../../AdminExternalization.json';

const useStyles = makeStyles((theme) => ({
    labelRoot: {
        color: '#344563',
        fontFamily: 'Roboto Condensed',
        fontSize: 12,
        fontWeight: 'bold',
        letterSpacing: 0,
        borderRadius: 4,
     
    },
    copy: {
        height: 28,
        width: 27.75
    }

}));

export default function KLTextFieldOutlined(props) {
    const classes = useStyles();
    const [open, setOpen] = React.useState(false);

    return (
            <FormControl variant="outlined" fullWidth>
                <OutlinedInput 
                    className={classes.labelRoot}
                    value={props.value}
                    endAdornment={

                        <InputAdornment position="end">
                            <CopyToClipboard
                                text={props.value} >
                                <img className={classes.copy} src={copyIcon} alt="Copy"
                                    onClick={()=>setOpen(true)} style={{ cursor: "pointer" }} />
                            </CopyToClipboard>
                        </InputAdornment>
                    }
                />
            <KLSnackBar open={open} message={adminData.linkCpoyAndShare.popupMsg} onClose={() => { setOpen(false) }} />
            </FormControl>
    );
}
















