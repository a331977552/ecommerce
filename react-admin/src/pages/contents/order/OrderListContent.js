import React, {Component} from 'react';
import {connect} from 'react-redux';
import {withRouter} from "react-router-dom";
import {bindActionCreators} from "redux";
import WithContentLoadingHOC from "../../../components/WithContentLoadingHOC";
import {Button, Cascader, Col, Dropdown, Form, Input, DatePicker, Menu, Modal, Popconfirm, Popover, Radio, Row, Select, Table, Tag, message, InputNumber} from "antd";
import {DownOutlined} from '@ant-design/icons';
import locale from 'antd/es/date-picker/locale/zh_CN';
import {httpListOrders} from "../../../data/http/HttpRequest";
import {refreshOrderListFailed, refreshOrderListLoading, refreshOrderListSucceed} from "../../../data/redux/reducers/order/OrderActionCreator";
import moment from 'moment';

class OrderListContent extends Component {
    dining_method = {
        eatIn: '店内就餐',
        takeaway: '打包带走'
    };
    dateFormat = "YYYY-MM-DD HH:mm";


    status = {
        UNPAID: '未付款',
        PAID: '已付款',
        SHIPPED: '已发货',
        COMPLETE: '已完成',
        CLOSED: '已关闭',
        REFUND: '已退款',
        CANCEL: '已取消',
    }

    statusOperationRender = (record) => (<Menu>
        {Object.keys(this.status).map(key =>
            record.status !== key && (<Menu.Item key={key}>
                {this.status[key]}
            </Menu.Item>))}
    </Menu>);

    state = {
        editingOrder: null
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
            width: '70px',
            render: (text, row, index) => index + 1
        },
        {
            title: <span>订单号/<span style={{color: 'red'}}>简易码</span></span>,
            width: '160px',
            dataIndex: 'order_number',
            render: (text, row, index) => (<span>{text.substring(0, text.length - row.order_code.length)}<span style={{color: 'red'}}>{row.order_code}</span></span>)
        },
        {
            title: '买家姓名',
            dataIndex: 'buyer',
            render: (text, row, index) => text
        },
        {
            title: '买家电话',
            width: '100px',
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
            width: '200px',
            dataIndex: 'operation',
            render: (_, record) => {
                return <span>
                      <a style={{marginRight: '16px'}} disabled={this.state.editingOrder !== null}
                         onClick={() => this.changeProductStatus(record)}>
                          详情
                      </a>
                        <Dropdown trigger={['click']} overlay={this.statusOperationRender(record)}>

                            <a disabled={this.state.editingOrder !== null} className="ant-dropdown-link" onClick={e => e.preventDefault()}>
                                修改状态<DownOutlined/>
                            </a>
                        </Dropdown>
                    </span>
            }
        }
    ]
    onOrderDateChanged = (dates, dateStrings) => {
        this.refreshData({example: {...this.props.example, start_create_time: dateStrings[0], end_create_time: dateStrings[1]}})
    };

    refreshData = ({orderBy = this.props.orderBy, by = this.props.by, example = this.props.example, pagination = this.props.pagination, resetPage = false}) => {

        this.props.refreshOrderListLoading({orderBy, by, example: {...example, customer: {...example.customer}}, pagination: {...pagination}});
        // if (example.categoryIds[0] === -1)
        //     example.categoryIds = [];
        if (resetPage) {
            pagination = {...pagination, current: 1}
        }

        message.loading("loading", 0);
        httpListOrders(pagination, orderBy, by, example, (res) => {
            this.props.refreshOrderListSucceed({dataPath: res.config.url, data: res.data});
            message.destroy();
            message.success("加载成功！");
        }, failed => {
            message.destroy();
            message.error(failed.message);
            this.props.refreshOrderListFailed();
        });
    };
    onSearchOrderNumber = (value) => {
            this.refreshData({example:{...this.props.example,order_number:value,buyer:null}})
    };
    onSearchCustomerName = (value) => {
            this.refreshData({example:{...this.props.example,buyer:value,order_number:null}})
    };



    render() {
        const {
            pagination, data, example, sorter, orderBy, by, categoryTreeData,
        } = this.props;
        const {start_create_time, end_create_time, order_number, buyer} = example;
        const createDatePickerDate = (start_create_time && end_create_time) ? [moment(start_create_time, this.dateFormat), moment(end_create_time, this.dateFormat)] : [];

        const {editingOrder} = this.state;
        const {items} = data;
        const categories = [{id: -1, value: -1, label: '所有种类'}, ...categoryTreeData];
        console.log(example)
        return (
            <div>
                <Row style={{marginBottom: '10px'}}>
                    检索:
                </Row>
                <Row>
                <Form.Item style={{marginRight: '40px'}} label={'下单日期:'}>
                    <DatePicker.RangePicker
                        showTime={{format: 'HH:mm'}}
                        ranges={{
                            '今天': [moment(), moment()],
                            '这个星期': [moment().startOf('week'), moment().endOf('week')],
                            '这个月': [moment().startOf('month'), moment().endOf('month')],
                            '上个星期': [moment().startOf('week').subtract(1, "week"), moment().endOf('week').subtract(1, "week")],
                            '上个月': [moment().startOf('month').subtract(1, "month"), moment().endOf('month').subtract(1, 'month')],

                        }}
                        format={"YYYY-MM-DD HH:mm"} locale={locale} onChange={this.onOrderDateChanged}
                        value={createDatePickerDate}/>
                </Form.Item>
                <Form.Item style={{marginRight: '40px'}} label={<span>订单号/<span style={{color: 'red'}}>码</span></span>}>
                    <Input.Search placeholder="10001" value={order_number} 	 required={true} type={'number'} style={{width: 200}} enterButton onSearch={this.onSearchOrderNumber}/>
                </Form.Item>
                    <Form.Item label={'顾客姓名'}>
                        <Input.Search placeholder="张三" value={buyer} required={true}   style={{width: 200}} enterButton onSearch={this.onSearchCustomerName}/>
                    </Form.Item>
                </Row>

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
                            scroll={{x: true}}
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
        refreshOrderListLoading,
        refreshOrderListFailed,
        refreshOrderListSucceed
    }, dispatch);
}

export default withRouter(connect(mapState, mapDispatch)(WithContentLoadingHOC(OrderListContent)));