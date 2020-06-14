import React, {Component} from 'react';
import {connect} from 'react-redux';
import {withRouter} from "react-router-dom";
import {bindActionCreators} from "redux";
import {Button, Form, Popconfirm, Table, message, Tag, Radio, Input, Row, Modal} from 'antd';
import WithContentLoadingHOC from "../../../components/WithContentLoadingHOC";
import {httpListProduct} from "../../../data/http/HttpRequest";
import {getRandomInt} from "../../../utils/UserDataUtils";
import {
    onProductListRefreshing, onProductListRefreshingFailed,
    onProductListRefreshingSucceed, updateProduct
} from "../../../data/redux/reducers/shop/ProductActionCreator";
import ProductEditModal from "./components/ProductEditModal";

class ProductEditContent extends Component {

    tagColors = [
        " magenta",
        " red",
        " volcano",
        " gold",
        " lime",
        " cyan",
        " blue",
        " geekblue",
    ]


    state = {
        editingModalVisibility:false,
        editingProduct:null
    }
    onProductAddClicked = (e) => {
        this.props.history.push("/shop/productAdd")
    }
    /**
     *
     * categoryIds: (2) [15, 3]
     create_date: "2020-05-17T12:06:22.973+0000"
     description: "一锅邵三鲜,地道绍兴菜14"
     discount: null
     hot: null
     id: 185
     imgs: Array(1)
     0: {id: 186, file_name: null, full_url: null, size: null, url: "https://i.picsum.photos/id/14/300/200.jpg"}
     length: 1
     __proto__: Array(0)
     merchant_id: 1
     name: "邵三鲜14"
     price: 12
     priceprev1: null
     priceprev2: null
     priority: null
     quantity_remaining: 111
     sales_volume: 58
     status: "ON_SALE"
     update_date: "2020-05-17T12:06:22.973+0000"
     weight: null
     *
     *
     * @type {({dataIndex: string, editable: boolean, title: string, render: (function(*, *, *): *)}|{dataIndex: string, editable: boolean, width: string, title: string, render: (function(*, *, *): *)}|{dataIndex: string, width: string, title: string, render: (function(*, *=): *)})[]}
     */



    columns = [
        {
            title: '商品名称',
            dataIndex: 'name',
            editable: true,
            render: (text, row, index) => (text)
        },
        {
            title: '价格',
            dataIndex: 'price',
            editable: true,
            render: (text, row, index) => (text)
        },
        {
            title: '种类',
            dataIndex: 'categories',
            editable: true,
            render: (record, row, index) => <span>{record.map(cate => <Tag  key={cate.id}
                color={this.tagColors[getRandomInt(this.tagColors.length)]}>{cate.title}</Tag>)}</span>
        },

        {
            title: '排名',
            dataIndex: 'priority',
            editable: true,
            render: (text, row, index) => (text)
        },
        {
            title: '库存',
            dataIndex: 'quantity_remaining',
            editable: true,
            render: (text, row, index) => (text)
        },
        {
            title: '销量',
            dataIndex: 'sales_volume',
            editable: true,
            render: (text, row, index) => (text)
        },
        {
            title: '状态',
            dataIndex: 'status',
            editable: true,
            render: (text, row, index) => (text)
        },
        {
            title: '创建日期',
            dataIndex: 'create_date',
            editable: true,
            render: (text, row, index) => (text)
        },
        {
            title: '描述',
            dataIndex: 'description',
            editable: true,
            render: (text, row, index) => text,
        },
        {
            title: '重量',
            dataIndex: 'weight',
            editable: true,
            render: (text, row, index) => (text)
        },
        {
            title: '更新日期',
            dataIndex: 'update_date',
            editable: true,
            render: (text, row, index) => (text)
        },

        {
            width: '100px',
            title: '图片',
            dataIndex: 'imgs',
            editable: true,
            //TODO
            render: (record, row, index) => <div style={{display: 'flex'}}>{record.map(img => <img key={img.id} width={'100px'}
                                                                                                   height={'100px'}
                                                                                                   src={img.url}
                                                                                                   alt={''}/>)}</div>,
        },
        {
            title: '操作',
            dataIndex: 'operation',
            render: (_, record) => {
                return <span>
                    <a style={{marginRight: '16px'}} disabled={this.state.editingProduct !== null}
                       onClick={() => this.onEditProduct(record)}>
                        编辑
                    </a>
                    <Popconfirm title="确定要删除吗?" onConfirm={() => this.delete(record.id)}>
                      <a disabled={this.state.editingProduct !== null}>删除</a>
                    </Popconfirm>
                    </span>
            }
        }
    ]

    onEditProduct = (product) => {
        this.setState({editingModalVisibility:true,
            editingProduct:product
        })
    }





    onStatusChanged = (e) => {
        const {orderBy, by} = this.props;
        const example = {...this.props.example, status: e.target.value};
        const pagination = {current: 1, pageSize: this.props.pagination.pageSize};
        this.refreshData({orderBy, by, example, pagination})
    }

    refreshData = ({orderBy = this.props.orderBy, by = this.props.by, example = this.props.example, pagination = this.props.pagination}) => {
        this.props.onProductListRefreshing({orderBy, by, example});
        message.loading("loading", 0);
        httpListProduct(pagination, 'priority', 'desc', example, (res) => {
            this.props.onProductListRefreshingSucceed({dataPath: res.config.url, data: res.data});
            message.destroy();
            message.success("加载成功！");
        }, failed => {
            message.destroy();
            message.error(failed.message);
            this.props.onProductListRefreshingFailed();
        });
    }

    onSearch = (value) => {
        this.refreshData({example: {...this.props.example,name: value}, pagination: {...this.props.pagination, current: 1}});
    }

    handleTableChange = (pagination, filters, sorter) => {
        const {orderBy, by, example} = this.props;
        this.refreshData({orderBy, by, example, pagination})
    }
    onEditingConfirmed = (finalProduct) => {
        this.props.updateProduct(finalProduct);
        this.setState({editingModalVisibility:false,editingProduct:null})
    }
    onEditCanceled = (e) => {
            this.setState({editingModalVisibility:false,editingProduct:null})
    }


    render() {
        console.log(this.props);
        const {pagination, data, example} = this.props;
        const {editingProduct} = this.state;
        const {items} = data;
        return (
            <div>
                <Row>
                    <Button style={{marginRight: '50px'}} onClick={this.onProductAddClicked}>添加商品</Button>
                    <Form.Item label={"筛选商品:"}>
                        <Radio.Group style={{marginRight: '50px'}} onChange={this.onStatusChanged}
                                     value={example.status}>
                            <Radio.Button value="IN_STOCK">已上架商品</Radio.Button>
                            <Radio.Button value="OUT_OF_STOCK">已下架商品</Radio.Button>
                        </Radio.Group>
                    </Form.Item>
                    <Form.Item label={"排序:"}>

                    </Form.Item>
                    <Form.Item label={"搜索:"}>
                        <Input.Search placeholder="商品名称" style={{width: 300}} enterButton onSearch={this.onSearch}/>
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
                        }} indentSize={40} rowKey={"id"} dataSource={items} bordered
                            onChange={this.handleTableChange}
                        />
                    </Form>
                </div>
                <Modal  title="商品编辑"
                        visible={this.state.editingModalVisibility}
                        onCancel={this.onEditCanceled}
                        width={800}
                        maskClosable={false}
                        footer={null}
                >
                    {this.state.editingModalVisibility&&<ProductEditModal onEditCanceled={this.onEditCanceled} onEditingConfirmed={this.onEditingConfirmed} product={{...editingProduct}} categories={this.props.categories}  categoryTreeData={this.props.categoryTreeData} />}
                </Modal>
            </div>
        );
    }
}

function mapState(state, props) {
    return {categories:state.categoryReducer.categories,categoryTreeData:state.categoryReducer.categoryTreeData};
}

const mapDispatch = (dispatch, ownProps) => {
    return bindActionCreators({
        onProductListRefreshing,
        onProductListRefreshingSucceed,
        onProductListRefreshingFailed,
        updateProduct

    }, dispatch);
}

export default withRouter(connect(mapState, mapDispatch)(WithContentLoadingHOC(ProductEditContent)));