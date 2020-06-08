import React, { Component } from 'react';
import { connect } from 'react-redux';
import {withRouter} from "react-router-dom";
import {bindActionCreators} from "redux";
import { Table } from 'antd';
import WithContentLoadingHOC from "../../../components/WithContentLoadingHOC";
class ProductEditContent extends Component {



 render() {
     console.log(this.props)
  return (
   <div>

   </div>
  );
 }
}
function mapState(state,props) {
 return {};
}

const mapDispatch = (dispatch, ownProps) => {
    return bindActionCreators({

    }, dispatch);
}

export default withRouter(connect(mapState,mapDispatch)(WithContentLoadingHOC(ProductEditContent)));