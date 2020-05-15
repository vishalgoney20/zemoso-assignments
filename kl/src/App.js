import React from 'react';
import './App.css';
import { BrowserRouter, Route } from 'react-router-dom'
import ReactBreakpoints from 'react-breakpoints'
import ProspectContactForm from './admin/ProspectContactForm'
import LinkCopyAndShare from './admin/LinkCopyAndShare'
import LinkSuccessful from './admin/LinkSuccessful'

function App() {

  const breakpoints = {
    mobile: 320,
    mobileLandscape: 500,
    tablet: 768,
    tabletLandscape: 1024,
    desktop: 1200,
    desktopLarge: 1500,
    desktopWide: 1920,
  }

  return (
    <BrowserRouter>
      <div className="App" >

        <Route exact path="/" component={ProspectContactForm} />
        <Route path="/newLink" component={LinkSuccessful} />

        <ReactBreakpoints breakpoints={breakpoints}>
          <Route path="/share" component={LinkCopyAndShare} />
        </ReactBreakpoints>

      </div>
    </BrowserRouter>
  );
}

export default App;
