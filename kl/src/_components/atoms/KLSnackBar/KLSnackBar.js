import React from 'react'
import { makeStyles, Snackbar } from '@material-ui/core'

const useStyles = makeStyles({
    root: {
        height: 36,
        color: '#FFFFFF',
        fontFamily: "Roboto Condensed",
        fontSize: 12,
        fontWeight: 'bold',
        letterSpacing: 0,
        borderRadius: 20,
        justifyContent: 'center',
        alignItems: 'center',
        paddingTop: 0,
        paddingBottom: 0,
        paddingLeft: 10,
        paddingRight: 10,
        flexGrow:0,
        marginTop:'25%',
        minWidth:'auto'
    }
});

function KLSnackBar(props) {
    const classes = useStyles();
    return (
        <div>
            <Snackbar
                anchorOrigin={{
                    vertical: 'center',
                    horizontal: 'center',
                }}
                open={props.open}
                onClose={props.onClose}
                autoHideDuration={1000}
                ContentProps={{
                    classes: {
                        root: classes['root']
                    }
                }}
                message={props.message}
            >
            </Snackbar>
        </div>
    );
}

export default KLSnackBar 


