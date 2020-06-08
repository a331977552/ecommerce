import React, { Component } from 'react';
import { connect } from 'react-redux';
import {withRouter} from "react-router-dom";
import {bindActionCreators} from "redux";
import { Result, Button } from 'antd';

class NotFound404Page extends Component {


 render() {
  return (
   <div>
       <Result
           status="404"
           title="404"
           subTitle="Sorry, the page you visited does not exist."
           extra={<Button type="primary">Back Home</Button>}
       />,
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
        //emptyCart: emptyCartAction
    }, dispatch);
}

export default withRouter(connect(mapState,mapDispatch)(NotFound404Page));