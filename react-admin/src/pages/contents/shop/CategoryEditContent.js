import React, { Component } from 'react';
import { connect } from 'react-redux';
import {withRouter} from "react-router-dom";
import {bindActionCreators} from "redux";

class CategoryEditContent extends Component {


 render() {
     console.log(this.props)
  return (
   <div>
       CategoryEditContent
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

export default withRouter(connect(mapState,mapDispatch)(CategoryEditContent));