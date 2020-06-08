import React, { Component } from 'react';
import { connect } from 'react-redux';
import {withRouter} from "react-router-dom";
import {bindActionCreators} from "redux";
import WithContentLoadingHOC from "../../components/WithContentLoadingHOC";
class HomeContent extends Component {



    render() {
  return (
   <div>
        home content
   </div>
  );
 }
}
function mapState(state) {
 return { };
}

const mapDispatch = (dispatch, ownProps) => {
    return bindActionCreators({

    }, dispatch);
}

export default withRouter(connect(mapState,mapDispatch)(WithContentLoadingHOC(HomeContent)));