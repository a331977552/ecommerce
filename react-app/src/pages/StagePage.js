import React from 'react';
import {connect} from "react-redux";
import {bindActionCreators} from "redux";
import {orderComplete,emptyCartAction} from "../data/actions/componentActionCreators";
import {ordering} from "../data/actions/httpActionCreators";
import {Link} from "react-router-dom";
import StageProductItem from "../componets/StageProductItem";
import Modal from 'react-modal';
// import { css } from "@emotion/core";
import MoonLoader from "react-spinners/MoonLoader";
import { withRouter } from 'react-router-dom'
import RadioButton from "../componets/form/RadioButton";
import Input from "../componets/form/Input";
import TextArea from "../componets/form/TextArea";
import './Modal.css'
import {httpOrdering} from '../data/http/HttpRequest'
Modal.setAppElement('#root')


export const EAT_IN = 'eatIn';
export const TAKE_AWAY = 'takeaway';

export const WECHAT = 'wechat';
export const ALIPAY = 'alipay';
export const BANK_CARD = 'bankCard';
export const CASH_ON_DELIVERY = 'cashOnDelivery';

export const paymentMap ={
    'wechat':'微信支付',
    'alipay':'支付宝支付',
    'bankCard':'银行卡支付',
    'cashOnDelivery':'货到付款',
}
class StagePage extends React.Component {

    lengthOfPhoneNumber = 10;
    titleFontSize = '14px';
    constructor(props) {
        super(props)
        this.state={
            diningMethod:EAT_IN,
            paymentMethod:WECHAT,
            phoneNumber:'',
            customerName:'',
            address:'',
            phoneNumberValid:true,
            customerNameValid:true,
            addressValid:true,
            comment:'',
            modalIsOpen:false,
            showOrderLoading:false
        }
    }

    /**
     *
     * @param item
     * @returns {boolean} true to delete item. false to keep
     * item will call this method
     */
    onDecreaseClick = (item) => {
        const remainingCount = Object.values(this.props.cart.cartItems).reduce((total,item) => total+item.quantity,0);
        if(remainingCount === 1){
            //todo beautify confirm dialog
            if(window.confirm("删除最后一个，将会返回上一页")){
                this.props.history.goBack();
                return true;
            }else{
                return  false;
            }
        }
        return true;
    }
    componentDidMount() {
        const remainingCount = Object.values(this.props.cart.cartItems).reduce((total,item) => total+item.quantity,0);

        if(remainingCount === 0)
            this.props.history.replace("/");

    }

    paymentMethodChanged = (e) =>{
        this.setState({
            paymentMethod:  e.target.value
        })
    }

    onDiningMethodChanged = (e) =>{
        this.setState({
            diningMethod:  e.target.value
        })
    }
    onOrderClicked = (e) =>{
        const {loading, success, cart,merchant} = this.props;
        const {diningMethod, customerName, phoneNumber, address,paymentMethod,comment} = this.state;
        const phoneNumberValid = this.onPhoneChanged({target: {value: phoneNumber}});
        const addressValid = this.onAddressChanged({target: {value: address}});
        const customerNameValid = this.onCustomerNameChanged({target: {value: customerName}});
        const cartItems = Object.values(cart.cartItems).filter(item => item.quantity > 0);
        if ( phoneNumberValid && customerNameValid && ( diningMethod === TAKE_AWAY ? addressValid : true)) {
           this.processOrder(paymentMethod,diningMethod, customerName, phoneNumber, address, cartItems,cart.totalPrice,merchant.id,comment)
        } else {
            alert("请完善订单信息!");
        }
    }

    processOrder = (paymentMethod,diningMethod, customerName, phoneNumber, address, cartItems,totalPrice,merchant_id,comment)=>{
        this.setState({
            showOrderLoading:true,
            modalIsOpen:true})
        httpOrdering({paymentMethod,diningMethod, customerName, phoneNumber, address, cartItems,totalPrice,merchant_id,comment},(orderResult)=>{
            console.log(orderResult);
            if(orderResult.id !== null && orderResult.id !== undefined && orderResult.order_code){
                this.setState({
                    showOrderLoading:false,
                    modalIsOpen:false})
                    this.props.emptyCartAction();
                    setTimeout(()=>{
                    this.props.history.replace("/orderComplete",{orderResult});
                    },10);
            }else{
                alert("订单异常");
            }

        },(error)=>{

            alert(error);

        });

    }

    onPhoneChanged = (e) => {
        const phoneNumber = e.target.value;
        const phoneNumberValid = phoneNumber.length >= this.lengthOfPhoneNumber;
        this.setState({
            phoneNumber,
            phoneNumberValid
        })
        return phoneNumberValid;
    }

    onCustomerNameChanged = (e) => {
        const customerName = e.target.value;
        const customerNameValid = customerName.length > 0;
        this.setState({
            customerName,
            customerNameValid
        })
        return customerNameValid;
    }
    onAddressChanged = (e) => {
        const address = e.target.value;
        const addressValid = address.length > 0;
        this.setState({
            address,
            addressValid
        })
        return addressValid;
    }
    onCommentChanged = (e) => {
        this.setState({comment: e.target.value})
    }
    afterOpenModal = (e) =>{

    }
    closeModal = (e) =>{

    }

    /**
     * quantity: 3
     id: 159
     subPrice:324
     product: {id: 159, name: "花雕醉龙虾 (小分)1", priceprev1: null, priceprev2: null, price: 118, …}
     updateItemInCar: cartItem => {…}
     *
     */
    render() {
        const {loading, success,cart,merchant} = this.props;
        const {diningMethod,customerName,phoneNumber,address,phoneNumberValid,customerNameValid,addressValid,modalIsOpen,showOrderLoading} = this.state;
        const cartItems=Object.values(cart.cartItems).filter(item => item.quantity > 0);
        if (!success) {
            if (loading)
                return <div>loading<Link to={"/menu"}>go back</Link></div>
            else {
                return <div>loading failed <button onClick={this.onRetryClicked}>retry</button></div>
            }
        } else
            return (
                <div style={{display: 'flex', flexDirection: 'column', backgroundColor: '#EEEEEE'}}>
                    <Modal
                        isOpen={modalIsOpen}
                        onAfterOpen={this.afterOpenModal}
                        onRequestClose={this.closeModal}
                        className="Modal"
                        overlayClassName="Overlay"
                        contentLabel="Example Modal"
                    >
                        {showOrderLoading&&<div style={{display:'flex',flexDirection:'column',justifyContent:'center',alignItems:'center'}}>
                            <div style={{marginBottom:'20px',fontSize:'14px'}}>正在为您下单,请稍候</div>
                            <MoonLoader
                                size={40}
                                color={"#36D7B7"}
                                loading={this.state.loading}
                            />
                        </div>
                            }
                    </Modal>

                    <div style={{
                        display: 'flex',
                        flexDirection: 'column',
                        height: '92vh',
                        overflow: 'scroll',
                        backgroundColor: '#EEEEEE',

                    }}>
                        <div debug={"商家名称"} >
                            <div style={{fontSize:this.titleFontSize,backgroundColor:'white',marginTop:'1px',padding:'10px 15px'}}>{merchant.name}</div>

                            <div style={{fontSize:'12px',backgroundColor:'white',marginTop:'1px',padding:'10px 15px'}}>地址:{merchant.address}</div>
                            <div style={{fontSize:'12px',backgroundColor:'white',padding:'10px 15px'}}>电话: {merchant.phone}</div>
                        </div>

                        <div debug={"取餐方式"} style={{backgroundColor:'white',marginTop:'5px',padding:'10px 15px'}}>
                            <div  style={{fontSize:this.titleFontSize}}>请选择取餐方式</div>
                            <div style={{display:'flex'}}>
                                <div style={{flex:'1 1 0',marginTop:'15px'}}>
                                    <RadioButton name="diningMethod"  checked={diningMethod === EAT_IN} value={EAT_IN} onChange={this.onDiningMethodChanged}  >堂吃</RadioButton>
                                </div>
                                <div  style={{flex:'1 1 0',marginTop:'15px'}}>
                                    <RadioButton name="diningMethod"  checked={diningMethod === TAKE_AWAY} value={TAKE_AWAY} onChange={this.onDiningMethodChanged}  >外卖</RadioButton>
                                </div>
                            </div>
                        </div>

                        <div debug={"delivery address"}  style={{backgroundColor:'white',marginTop:'5px',padding:'10px 15px'}}>
                            <div style={{fontSize:this.titleFontSize,marginBottom:'15px'}}>
                                { this.state.diningMethod === TAKE_AWAY ? '请填写送货地址' : '顾客信息'}</div>
                            <div style={{marginTop:'5px'}}>
                                <Input valid={customerNameValid} errorMsg={'用户名不能为空'}  labelStyle={{fontSize:this.titleFontSize}}   required={true}  label={"姓名"}     placeholder={''} type={'text'}   name={'customerName'} maxLength={20} onChange={this.onCustomerNameChanged} />
                                <Input valid={phoneNumberValid} errorMsg={'电话号码不能为空或少于'+this.lengthOfPhoneNumber+'位'}  labelStyle={{fontSize:this.titleFontSize}}   required={true}  label={"电话号码"} placeholder={''} type={'number'} name={'phoneNumber'} size={16} maxLength={16} onChange={this.onPhoneChanged} />
                                { this.state.diningMethod === TAKE_AWAY &&<TextArea valid={addressValid} errorMsg={'送货地址不能为空'} labelStyle={{fontSize:this.titleFontSize}} required={true}  label={'配送地址'} placeholder={''}                 name={'address'} maxLength={200}  rows={'3'} onChange={this.onAddressChanged}/>}
                            </div>
                        </div>

                        <div>
                            <div style={{fontSize:this.titleFontSize,backgroundColor:'white',marginTop:'5px',padding:'15px'}}>支付方式</div>
                            <div debug={"支付方式"} style={{backgroundColor:'white',marginTop:'1px',padding:'10px 15px',display:'flex',justifyContent:'space-between',alignItems:'center'}}>
                                <div>
                                    <div style={{fontSize:this.titleFontSize,}}>差图标-- 微信支付</div>
                                    <div style={{fontSize:'12px',marginTop:'5px'}}>添加商家微信,自行转账</div>
                                </div>
                                <RadioButton name="paymentMethod"  onChange={this.paymentMethodChanged} checked={this.state.paymentMethod === WECHAT} value={WECHAT}   />
                            </div>
                            <div debug={"支付方式"} style={{backgroundColor:'white',marginTop:'1px',padding:'10px 15px',display:'flex',justifyContent:'space-between'}}>
                                <div  style={{fontSize:this.titleFontSize}}>差图标-- 货到付款</div>
                                <RadioButton name="paymentMethod" onChange={this.paymentMethodChanged}  checked={this.state.paymentMethod === CASH_ON_DELIVERY} value={CASH_ON_DELIVERY}   />
                            </div>
                            <div debug={"支付方式"} style={{backgroundColor:'white',marginTop:'1px',padding:'10px 15px',display:'flex',justifyContent:'space-between'}}>
                                <div  style={{fontSize:this.titleFontSize}}>差图标-- 银行卡打款</div>
                                <RadioButton name="paymentMethod" onChange={this.paymentMethodChanged}  checked={this.state.paymentMethod === BANK_CARD} value={BANK_CARD}   />
                            </div>
                        </div>

                        <div debug={"备注"} style={{backgroundColor:'white',marginTop:'5px',padding:'15px'}}>
                            <TextArea labelFontSize={this.titleFontSize} label={'备注'} name={'comment'} rows={'4'} onChange={this.onCommentChanged}/>
                        </div>

                        <div >
                            <div  style={{fontSize:this.titleFontSize,backgroundColor:'white',marginTop:'5px',padding:'15px'}}>商品列表</div>
                                {
                                    cartItems.map(item=><StageProductItem onDecreaseClick={this.onDecreaseClick} key={item.id} {...item} />
                                    )
                                }

                        </div>

                        <div debug={"发票需求"} style={{backgroundColor:'white',margin:'5px 0 5px 0',padding:'15px'}}>
                            <div>如需发票请联系门店索取</div>
                        </div>
                    </div>
                    <div style={{height:'8vh',backgroundColor:'white'}}>
                        <div style={{
                            width: '100%',
                            height: '100%',
                            display: 'flex',
                            justifyContent: 'center',
                            padding: '15px',
                            alignItems: 'center',
                            flexDirection: 'row'
                        }}>
                            <span style={{padding: '10px',flexGrow: '1'}}>  合计：￥ {cart.totalPrice}</span>
                            <div>
                                <button style={{padding: 10}} onClick={this.onOrderClicked}>
                                    下单支付
                                </button>
                            </div>
                        </div>
                    </div>

                </div>)

    }

}

const mapState = (state, props) => {
    const {loading, success, cart,merchant} = state.menuReducer;
    return {loading, success, cart,merchant}
}
const mapDispatch = (dispatch, ownProps) => {
    return bindActionCreators({
        ordering,
        orderComplete,
        emptyCartAction
    }, dispatch);
}

export default withRouter(connect(mapState, mapDispatch)(StagePage));
