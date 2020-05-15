import React from 'react'
import { action } from '@storybook/addon-actions'
import KLSnackBar from '../KLSnackBar/KLSnackBar'

export default {
  title: 'Check Snackbar',
  component: KLSnackBar,
};
const name=("Link copied");

export const Snackbar = () => <KLSnackBar open={action('Entered text')} message={name}></KLSnackBar>;

