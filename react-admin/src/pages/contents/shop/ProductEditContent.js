import React, {Component} from 'react';
import {connect} from 'react-redux';
import {withRouter} from "react-router-dom";
import {bindActionCreators} from "redux";
import {
    Button,
    Form,
    Popconfirm,
    Table,
    message,
    Tag,
    Radio,
    Input,
    Row,
    Modal,
    Cascader, Select
} from 'antd';
import WithContentLoadingHOC from "../../../components/WithContentLoadingHOC";
import {httpListProducts, httpUpdateProduct, httpDeleteProduct} from "../../../data/http/HttpRequest";
import {
    deleteProduct,
    onProductListRefreshing, onProductListRefreshingFailed,
    onProductListRefreshingSucceed, updateProduct, updateProductStatus
} from "../../../data/redux/reducers/shop/ProductActionCreator";
import ProductEditModal from "./components/ProductEditModal";

class ProductEditContent extends Component {
    state = {
        editingModalVisibility: false,
        editingProduct: null
    }
    onProductAddClicked = (e) => {
        this.props.history.push("/shop/productAdd")
    }
    columns = [
        {
            title: '索引',
            dataIndex: 'index',
            width:'50px',
            editable: false,
            render: (text, row, index) => index + 1
        },
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
            render: (record, row, index) => <span>{record.map(cate => <Tag key={cate.id} >{cate.title}</Tag>)}</span>
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
            render: (text, row, index) => (text === 'IN_STOCK' ? '上架中' : '已下架')
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
            render: (record, row, index) => <div style={{display: 'flex'}}>{record.map(img => <img key={img.id}
                                                                                                   width={'100px'}
                                                                                                   height={'100px'}
                                                                                                   src={img.thumbnail_url || img.url}
                                                                                                   alt={''}/>)}</div>,
        },
        {
            title: '操作',
            width:'150px',
            dataIndex: 'operation',
            render: (_, record) => {
                return <span>
                    <a style={{marginRight: '16px'}} disabled={this.state.editingProduct !== null}
                       onClick={() => this.onEditProduct(record)}>
                        编辑
                    </a>
                      <a style={{marginRight: '16px'}} disabled={this.state.editingProduct !== null}
                         onClick={() => this.changeProductStatus(record)}>{record.status === 'IN_STOCK' ? '下架' : '上架'}</a>

                    <Popconfirm title="确定要删除吗?" onConfirm={() => this.delete(record)}>
                      <a disabled={this.state.editingProduct !== null}>删除</a>
                    </Popconfirm>

                    </span>
            }
        }
    ]

    onEditProduct = (product) => {
        this.setState({
            editingModalVisibility: true,
            editingProduct: product
        })
    }


    changeProductStatus = (product) => {
        const finalProduct = {...product, status: product.status === 'IN_STOCK' ? 'OUT_OF_STOCK' : 'IN_STOCK'};
        httpUpdateProduct(finalProduct, (response) => {
            this.props.updateProductStatus(finalProduct);
            message.success((product.status === 'IN_STOCK' ? '下架' : '上架') + "商品 " + finalProduct.name + " 成功!");
        }, fail => {
            message.error(fail.message);
        });
    }


    onFilterStatusChanged = (e) => {
        const {orderBy, by} = this.props;
        const example = {...this.props.example, status: e.target.value};
        const pagination = {current: 1, pageSize: this.props.pagination.pageSize};
        this.refreshData({orderBy, by, example, pagination})
    }
    delete = (product) => {
        httpDeleteProduct(product.id, () => {
            this.props.deleteProduct({...product});
            message.success("删除成功！");
        }, (fail) => {
            message.error(fail.message);
        });
    };


    refreshData = ({orderBy = this.props.orderBy, by = this.props.by, example = this.props.example, pagination = this.props.pagination, resetPage = false}) => {
        this.props.onProductListRefreshing({orderBy, by, example: {...example}, pagination: {...pagination}});
        if (example.categoryIds[0] === -1)
            example.categoryIds = [];
        if (resetPage) {
            pagination = {...pagination, current: 1}
        }

        message.loading("loading", 0);
        httpListProducts(pagination, orderBy, by, example, (res) => {
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
        this.refreshData({example: {...this.props.example, name: value}, resetPage: true});
    }

    handleTableChange = (pagination, filters, sorter) => {
        this.refreshData({pagination})
    }
    onEditingConfirmed = (finalProduct) => {
        this.props.updateProduct(finalProduct);
        this.setState({editingModalVisibility: false, editingProduct: null})
    }
    onEditCanceled = (e) => {
        this.setState({editingModalVisibility: false, editingProduct: null})
    }
    onCategoryChange = (categoryIds) => {
        const {example: temp} = this.props;
        const example = {...temp, categoryIds};
        this.refreshData({example, resetPage: true});
    }
    onSorterChange = (orderBy) => {
        this.refreshData({orderBy, resetPage: true});
    }
    onByChanged = (value) => {
        this.refreshData({by: value, resetPage: true});
    }


    render() {
        const {pagination, data, example, sorter, orderBy, by, categoryTreeData} = this.props;
        const {editingProduct} = this.state;
        const {items} = data;
        const categories = [{id: -1, value: -1, label: '所有种类'}, ...categoryTreeData];
        return (
            <div>
                <Row>
                    <Button style={{marginRight: '40px'}} onClick={this.onProductAddClicked}>添加商品</Button>
                    <Form.Item style={{marginRight: '40px'}} label={"筛选商品:"}>
                        <Radio.Group onChange={this.onFilterStatusChanged}
                                     value={example.status}>
                            <Radio.Button value="">所有商品</Radio.Button>
                            <Radio.Button value="IN_STOCK">已上架商品</Radio.Button>
                            <Radio.Button value="OUT_OF_STOCK">已下架商品</Radio.Button>
                        </Radio.Group>
                    </Form.Item>
                    <Form.Item style={{marginRight: '40px'}} label="种类">
                        <Cascader showSearch={{matchInputWidth: true}} options={categories} value={example.categoryIds}
                                  onChange={this.onCategoryChange} placeholder="请选择种类"/>
                    </Form.Item>

                    <Form.Item style={{marginRight: '5px'}} label={"排序:"}>
                        <Select style={{width: 200}} value={orderBy} onChange={this.onSorterChange}>
                            {sorter.map(item => <Select.Option key={item.value} value={item.value}>{item.label}</Select.Option>)}
                        </Select>
                    </Form.Item>
                    <Form.Item style={{marginRight: '40px'}}>
                        <Select style={{width: 100}} value={by} onChange={this.onByChanged}>
                            <Select.Option  value='desc'>降序</Select.Option>
                            <Select.Option  value='asc'>升序</Select.Option>
                        </Select>

                    </Form.Item>

                    <Form.Item label={"搜索:"}>
                        <Input.Search placeholder="商品名称"  defaultValue={example.name} style={{width: 300}} enterButton onSearch={this.onSearch}/>
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
                            scroll={{x:true}}
                            onChange={this.handleTableChange}
                        />
                    </Form>
                </div>
                <Modal title="商品编辑"
                       visible={this.state.editingModalVisibility}
                       onCancel={this.onEditCanceled}
                       width={800}
                       maskClosable={false}
                       footer={null}
                >
                    {this.state.editingModalVisibility &&
                    <ProductEditModal onEditCanceled={this.onEditCanceled} onEditingConfirmed={this.onEditingConfirmed}
                                      product={{...editingProduct}} categories={this.props.categories}
                                      categoryTreeData={this.props.categoryTreeData}/>}
                </Modal>
            </div>
        );
    }
}

function mapState(state, props) {
    return {categoryTreeData: state.categoryReducer.categoryTreeData};
}

const mapDispatch = (dispatch, ownProps) => {
    return bindActionCreators({
        onProductListRefreshing,
        onProductListRefreshingSucceed,
        onProductListRefreshingFailed,
        updateProduct,
        updateProductStatus,
        deleteProduct

    }, dispatch);
}

export default withRouter(connect(mapState, mapDispatch)(WithContentLoadingHOC(ProductEditContent)));