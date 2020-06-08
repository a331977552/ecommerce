import React, { Component } from 'react';
import { connect } from 'react-redux';
import {withRouter} from "react-router-dom";
import {bindActionCreators} from "redux";
import WithContentLoadingHOC from "../../../components/WithContentLoadingHOC";

class AdvertiseContent extends Component {


    render() {
  return (
   <div>
       AdvertiseContent
   </div>
  );
 }
}
function mapState(state) {
    console.log(state)
 return { };
}

const mapDispatch = (dispatch, ownProps) => {
    return bindActionCreators({
    }, dispatch);
}

export default withRouter(connect(mapState,mapDispatch)(WithContentLoadingHOC(AdvertiseContent)));