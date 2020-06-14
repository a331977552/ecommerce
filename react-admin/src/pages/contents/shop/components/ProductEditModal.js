import React, {Component} from 'react';
import {connect} from 'react-redux';
import {withRouter} from "react-router-dom";
import {bindActionCreators} from "redux";
import {Button, Cascader, Form, Input, InputNumber, message, notification, Select, Radio} from "antd";
import PicUpload from "../../../../components/PicUpload";
import {httpAddProduct, httpUpdateProduct} from "../../../../data/http/HttpRequest";

const { Option } = Select;
class ProductEditModal extends Component {
    form = React.createRef();
    onFinish = (productTouched) => {
        const {product: newProduct} = this.props;
        const finalProduct = {...newProduct, ...productTouched};
        httpUpdateProduct(finalProduct, (response) => {
            this.props.onEditingConfirmed(finalProduct);
            notification.success({message: "修改商品成功!"});
        }, fail => {
            message.error(fail.message);
        });
    };

    render() {
        const {product, categoryTreeData} = this.props;
        return (
            <div>
                <Form
                    scrollToFirstError={true}
                    labelAlign={"right"}
                    labelCol={{
                        span: 4, offset: 1,
                    }}
                    wrapperCol={{
                        span: 18, offset: 0
                    }}
                    ref={this.form}
                    name="nest-messages" onFinish={this.onFinish}>
                    <Form.Item name={'name'} initialValue={product.name} label="商品名称" rules={[{required: true}]}>
                        <Input/>
                    </Form.Item>

                    <Form.Item name={'price'} label="价格" initialValue={product.price || 0}
                               rules={[{type: 'number', min: 0, max: 999999}]}>
                        <InputNumber/>
                    </Form.Item>
                    <Form.Item name={'quantity_remaining'} label="库存" initialValue={product.quantity_remaining || 0}
                               rules={[{type: 'number', min: 0, max: 999999}]}>
                        <InputNumber/>
                    </Form.Item>
                    <Form.Item name={'priority'} label="排名" extra={"数值越小 排名越靠前 最小值为0  最大值为 999999"}
                               initialValue={product.priority}
                               rules={[{type: 'number', min: 0, max: 999999}]}>
                        <InputNumber placeholder={"商品排名"}/>
                    </Form.Item>
                    <Form.Item name={'sales_volume'} label="商品销量" extra={"商品销量,默认为0,商家可自行设置."}
                               initialValue={product.sales_volume || 0}
                               rules={[{type: 'number', min: 0, max: 999999}]}>
                        <InputNumber placeholder={"商品销量"}/>
                    </Form.Item>

                    <Form.Item name={['categoryIds']} label="种类" extra={"商品种类, 目前仅支持单层级"}
                               initialValue={product.categoryIds} rules={[{required: true}]}>
                        <Cascader showSearch={{matchInputWidth: true}} options={categoryTreeData}
                                  onChange={this.onChange} placeholder="请选择种类"/>
                    </Form.Item>
                    <Form.Item name={'weight'} label="重量(克)" extra={"商品重量, 可不填"} initialValue={product.weight}
                               rules={[{type: 'number', min: 0, max: 999999}]}>
                        <InputNumber placeholder={"商品重量"}/>
                    </Form.Item>
                    <Form.Item name={'status'} label="商品状态" extra={"默认为上架状态"} initialValue={product.status}
                               rules={[{required: true}]}>
                        <Radio.Group>
                            <Radio.Button value="IN_STOCK">上架商品</Radio.Button>
                            <Radio.Button value="OUT_OF_STOCK">下架商品</Radio.Button>
                        </Radio.Group>

                    </Form.Item>
                    <Form.Item name={['description']} label="描述" rules={[{required: true}]}
                               initialValue={product.description}>
                        <Input.TextArea rows={4}/>
                    </Form.Item>
                    <Form.Item label="图片上传" name={['imgs']} valuePropName={'imgIdList'}
                               trigger={'imgIdList'} extra={"默认第一张会作为封面"} validateTrigger={'imgIdList'}
                               rules={[{required: true, message: '请至少上传一张图片'}]}>
                        <PicUpload fileList={product.imgs}/>
                    </Form.Item>

                    <div style={{display:'flex',justifyContent:'center'}}>
                        <Button type="primary" htmlType="submit">
                            确定
                        </Button>
                        <Button style={{marginLeft:'10px'}} onClick={this.props.onEditCanceled}>
                            取消
                        </Button>
                    </div>
                </Form>
            </div>
        );
    }
}

function mapState(state) {
    console.log(state)
    return {};
}

const mapDispatch = (dispatch, ownProps) => {
    return bindActionCreators({
        //emptyCart: emptyCartAction
    }, dispatch);
}

export default withRouter(connect(mapState, mapDispatch)(ProductEditModal));