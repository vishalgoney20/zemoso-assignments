import React from 'react';
import { action } from '@storybook/addon-actions';
import KLTextField from '../KLTextField/KLTextField';

export default {
  title: 'Check Field Input',
  component: KLTextField,
};

export const FieldInput = () => <KLTextField onChange={action('Entered text')}></KLTextField>;

