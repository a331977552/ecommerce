import React, { Component } from 'react';
import { connect } from 'react-redux';
import {withRouter} from "react-router-dom";
import {bindActionCreators} from "redux";

class AppLogo extends Component {
 render() {
  return (
       <div style={{
           height: '32px',
           background: 'rgba(255, 255, 255, 0.2)',
           margin: '16px'
       }}/>
  );
 }
}
function mapState(state) {
 return { };
}

const mapDispatch = (dispatch, ownProps) => {
    return bindActionCreators({
        //emptyCart: emptyCartAction
    }, dispatch);
}

export default withRouter(connect(mapState,mapDispatch)(AppLogo));