import React, { Component } from 'react';
import { connect } from 'react-redux';
import {withRouter} from "react-router-dom";
import {bindActionCreators} from "redux";
import {Button, Col, Row, Table} from 'antd';
import WithContentLoadingHOC from "../../../components/WithContentLoadingHOC";
class ProductEditContent extends Component {

    onProductAddClicked = (e) => {
        this.props.history.push("/shop/productAdd")
    }


 render() {
     console.log(this.props)
  return (
   <div>
        <Row>
            <Col><Button onClick={this.onProductAddClicked}>添加商品</Button></Col>
        </Row>
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