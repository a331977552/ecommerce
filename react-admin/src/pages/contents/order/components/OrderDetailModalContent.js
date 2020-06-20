import React, {Component} from 'react';
import {connect} from 'react-redux';
import {withRouter} from "react-router-dom";
import {bindActionCreators} from "redux";
import {Button, Cascader, Form, Input, InputNumber, message, notification, Select, Radio, List, Avatar, Skeleton, Result, Spin} from "antd";
import {httpFindOrderDetailById} from "../../../../data/http/HttpRequest";

class OrderDetailModalContent extends Component {

    state = {
        data: null,
        loading: true,
        success: false,
        message: ''
    }

    componentDidMount() {
        this.loadingDate();
    }

    loadingDate = () => {
        this.setState({
            data: null,
            loading: true,
            success: false,
            message: ''
        });
        httpFindOrderDetailById(this.props.order.id, (response) => {
            console.log(response.data)
            this.setState({data: response.data, loading: false, success: true});
        }, (failed) => {
            this.setState({loading: false, success: false, message: failed.message});
        });

    };


    render() {

        const {data, loading, success, message} = this.state;
        if (loading)
            return <Spin tip="Loading..."><Skeleton/></Spin>;
        else if (!success)
            return <Result
                title="服务器异常"
                subTitle={message}
                extra={<Button type="primary" onClick={this.loadingDate}>重试</Button>}
            />;

        const {orderItems} = data;
        /**
         * displayPrice: null
         id: 23
         img: "https://i.picsum.photos/id/14/300/200.jpg"
         order_id: 11
         product_desc: "一锅邵三鲜,地道绍兴菜14"
         product_id: 185
         product_name: "邵三鲜14"
         quantity: 7
         sub_total: 84
         uniprice: 12
         *
         */
        return (
            <div>
                <List
                    itemLayout="horizontal"
                    dataSource={orderItems}
                    renderItem={item => (
                        <List.Item>
                            <div style={{display:'flex'}}>
                                <div style={{width:200}}>
                                    <img src={item.img}/>
                                </div>
                                <div >

                                    {item.product_name}
                                    {item.product_desc}
                                </div>
                            </div>
                        </List.Item>
                    )}/>
            </div>
        );
    }
}

function mapState(state) {
    return {};
}

const mapDispatch = (dispatch, ownProps) => {
    return bindActionCreators({}, dispatch);
}

export default withRouter(connect(mapState, mapDispatch)(OrderDetailModalContent));