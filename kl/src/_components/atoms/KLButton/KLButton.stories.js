import React from 'react';
import { action } from '@storybook/addon-actions'
import { storiesOf } from '@storybook/react'
import { withKnobs, text} from "@storybook/addon-knobs"
import KLButton from '../KLButton/KLButton'


export const stories=storiesOf("Check ButtonComponent",module);
stories.addDecorator(withKnobs);
stories.add("button",()=>{

const name=text("name","Generate Link");
   
  return <KLButton value={name}
   onClick={action('click') }> 
   
      </KLButton>
   
}
);

