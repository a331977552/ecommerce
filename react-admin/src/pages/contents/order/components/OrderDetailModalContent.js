import React, {Component} from 'react';
import {connect} from 'react-redux';
import {withRouter} from "react-router-dom";
import {bindActionCreators} from "redux";
import {Button, Cascader, Form, Input, InputNumber, message, notification, Select, Radio} from "antd";
import {httpFindOrderDetailById} from "../../../../data/http/HttpRequest";

class OrderDetailModalContent extends Component {


    componentDidMount() {
        console.log('componentDidMount')
        httpFindOrderDetailById(this.props.order.id,(response)=>{

            message.success("haha")
        },(failed)=>{
            message.error(failed.message)
        });

    }

    render() {
        return (
            <div >

            </div>
        );
    }
}

function mapState(state) {
    return {};
}

const mapDispatch = (dispatch, ownProps) => {
    return bindActionCreators({
    }, dispatch);
}

export default withRouter(connect(mapState, mapDispatch)(OrderDetailModalContent));