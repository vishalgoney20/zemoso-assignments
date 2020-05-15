import React from 'react'
import TextField from '@material-ui/core/TextField'
import { makeStyles } from '@material-ui/core'

const useStyles = makeStyles({
    inputRoot: { 
      color: '#344563',
      fontFamily: 'Roboto Condensed',
      fontSize: 14,
      letterSpacing: 0,
      width:'100%',
    },
    labelRoot: {
      fontFamily: 'Roboto Condensed',
      fontSize: 12,
      letterSpacing: 0,
      fontWeight:'bold',
      color: "#979DA9",
          "&$labelFocused": {
         color: "#979DA9"
    }
    },
    labelFocused: {}
});


function KLTextField(props){
    const classes = useStyles();
    return(
        <TextField required={props.required} label={props.label}
            fullWidth={true}
            InputProps={{ classes: { root: classes.inputRoot } }}
            InputLabelProps={{ 
                classes: { root: classes.labelRoot,
                    focused: classes.labelFocused
                } 
            }}
            value={props.value} name={props.name} onChange={props.onChange} 
            error={props.error} helperText={props.helperText}
            />
    );  
}

export default KLTextField