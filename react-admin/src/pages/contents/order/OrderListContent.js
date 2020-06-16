import React, { Component } from 'react';
import { connect } from 'react-redux';
import {withRouter} from "react-router-dom";
import {bindActionCreators} from "redux";
import WithContentLoadingHOC from "../../../components/WithContentLoadingHOC";
import {Button, Cascader, Form, Input, Modal, Popconfirm, Radio, Row, Select, Table, Tag} from "antd";

class OrderListContent extends Component {
    dining_method = {
        eatIn:'店内就餐',
        takeaway:'打包带走'
    };
    status = {
        UNPAID:'未付款',
        PAID: '已付款',
        SHIPPED: '已发货',
        CLOSED: '交易完成',
        REFUND: '已退款'
    }

    state = {
        editingOrder:null
    }
    /*


        String order_number;
        String order_code;
        String user.name;
        String user.phone;
        String dining_method;
        String address;
        String create_time;
        String status;
        String total_price;
        String detail;
        String operation;

        private Integer id;
        Date expired_time;
        String buyer;
        String comment;
        Date create_time;
        String payment_method;
        String phone;
        String status;
        Date takeaway_time;
        Integer total_count;
        BigDecimal total_price;
        Date update_time;
        Integer user_id;
        String dining_method;
        DeliveryAddressVO address;
        CustomerVO customer;
        List<OrderItemVO> orderItems;
        MerchantVO merchant;
    */
    columns = [
        {
            title: '索引',
            dataIndex: 'index',
            width:'70px',
            render: (text, row, index) => index + 1
        },
        {
            title: <span>订单号/<span style={{color:'red'}}>简易码</span></span>,
            width: '160px',
            dataIndex: 'order_number',
            render: (text, row, index) => (<span>{text.substring(0,text.length-row.order_code.length)}<span style={{color:'red'}}>{row.order_code}</span></span>)
        },
        {
            title: '买家姓名',
            dataIndex: 'buyer',
            render: (text, row, index) => text
        },
        {
            title: '买家电话',
            width:'100px',
            dataIndex: 'phone',
            editable: true,
            render: (text, row, index) => (text)
        },
        {
            title: '用餐方式',
            dataIndex: 'dining_method',
            render: (text, row, index) => (this.dining_method[text])
        },
        {
            title: '配送地址',
            dataIndex: 'address',
            editable: true,
            render: (text, row, index) => (text)
        },
        {
            title: '下单时间',
            dataIndex: 'create_time',
            render: (text, row, index) => text
        },
        {
            title: '订单状态',
            dataIndex: 'status',
            render: (text, row, index) => (this.status[text])
        },
        {
            title: '订单总价',
            dataIndex: 'total_price',
            render: (text, row, index) => text,
        },
        {
            title: '操作',
            width:'150px',
            dataIndex: 'operation',
            render: (_, record) => {
                return <span>
                      <a style={{marginLeft: '16px'}} disabled={this.state.editingOrder !== null}
                         onClick={() => this.changeProductStatus(record)}>详情</a>
                      <a disabled={this.state.editingOrder !== null}>修改订单状态</a>
                    </span>
            }
        }
    ]


 render() {

     const {pagination, data, example, sorter, orderBy, by, categoryTreeData} = this.props;
     const {editingOrder} = this.state;
     const {items} = data;
     const categories = [{id: -1, value: -1, label: '所有种类'}, ...categoryTreeData];

  return (
   <div>
           <div>
               <Form ref={this.form} component={false}>
                   <Table
                       showSorterTooltip={true}
                       ellipsis={true}
                       pagination={pagination}
                           columns={this.columns} components={{
                           body: {
                           cell: this.EditableCell,
                       },
                   }} indentSize={40} rowKey={"id"} dataSource={items}
                       bordered
                       scroll={{x:true}}
                       onChange={this.handleTableChange}
                   />
               </Form>
           </div>
   </div>
  );
 }
}
function mapState(state) {
    return {categoryTreeData: state.categoryReducer.categoryTreeData};
}

const mapDispatch = (dispatch, ownProps) => {
    return bindActionCreators({

    }, dispatch);
}

export default withRouter(connect(mapState,mapDispatch)(WithContentLoadingHOC(OrderListContent)));