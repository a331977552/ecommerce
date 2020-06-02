import React, { Component } from 'react';
import { connect } from 'react-redux';
import {withRouter} from "react-router-dom";
import {bindActionCreators} from "redux";
import {Breadcrumb} from "antd";

class AppBreadcrumb extends Component {
 render() {
     const items = this.props.selectedKey.split('/');
     items.shift();


  return (
       <Breadcrumb style={{margin: '8px 0'}}>
           {
               items.map(item=><Breadcrumb.Item key={item}>{item===''?'Home':item}</Breadcrumb.Item>)
           }
       </Breadcrumb>
  );
 }
}
function mapState(state) {

 return state.menuReducer;
}

const mapDispatch = (dispatch, ownProps) => {
    return bindActionCreators({
        //emptyCart: emptyCartAction
    }, dispatch);
}

export default withRouter(connect(mapState,mapDispatch)(AppBreadcrumb));