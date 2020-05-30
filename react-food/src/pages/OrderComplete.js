import React, {Component} from 'react';
import {connect} from 'react-redux';
import {withRouter} from 'react-router-dom'
import {ALIPAY, BANK_CARD, CASH_ON_DELIVERY, paymentMap, TAKE_AWAY, WECHAT} from "./StagePage";



class OrderComplete extends Component {

    constructor(props) {
        super(props);

    }

    componentDidMount() {
    }


    render() {
        const {orderResult} = this.props.location.state;
        console.log(orderResult)

        /**
         *
         private Integer id;

         private String name;

         private String notice;

         private String status;

         private String address;

         private String availability;
         * address :
         *
         * private Integer id;

         private String address;

         private String phone;

         private String name;

         private String postcode;

         private Integer user_id;
         *
         *
         */

        const {comment, order_code, order_number, payment_method, phone, status, total_price, dining_method, address, customer, orderItems, merchant, create_time} = orderResult;
        console.log({
                comment,
                order_code,
                order_number,
                payment_method,
                phone,
                status,
                total_price,
                dining_method,
                address,
                customer,
                orderItems,
            },
            merchant
        )
        return (

            <div style={{
                display: 'flex',
                flexDirection: 'column',
                height: '100%',
                overflow: 'scroll',
                backgroundColor: '#EEEEEE',
                fontSize:'14px'

            }}>
                <div debug={"商家名称"} style={{backgroundColor: 'white', marginTop: '1px', padding: '10px 15px'}}>
                    <div style={{fontSize: this.titleFontSize}}>{merchant.name}</div>
                    <div style={{fontSize: '12px', marginTop: '5px'}}>地址: {merchant.address}</div>
                    <div style={{fontSize: '12px', marginTop: '5px'}}>电话号码: {merchant.phone}</div>
                </div>
                <div style={{marginTop: '5px'}}>
                    <div style={{fontSize: this.titleFontSize, backgroundColor: 'white', padding: '10px 15px'}}>
                        支付方式:<span
                        style={{marginLeft: '20px'}}> {paymentMap[payment_method]}</span>
                    </div>
                    <div style={{
                        display: 'flex',
                        flexDirection: 'column',
                        alignItems: 'center',
                        backgroundColor: 'white',
                        marginTop: '1px'
                    }}>
                        <div style={{padding: '10px',width:'100%' }}>
                            <div style={{marginBottom:'10px'}}>可先添加商家进行确认:</div>
                            {payment_method === WECHAT &&
                            <div style={{display:'flex',justifyContent:'space-between',width:'100%'}}>
                                <img  alt={merchant.name+"微信号"} style={{width:'40vw'}}src={merchant.wechat_url}/>
                                <img alt={merchant.name+"支付码"} style={{width:'40vw'}} src={merchant.wechat_payment_code_url}/>
                            </div>
                            }
                            {payment_method === ALIPAY &&
                            <div style={{display:'flex',justifyContent:'space-between',width:'100%'}}>
                                <img alt={merchant.name} style={{width:'40vw'}} src={merchant.alipay_url}/>

                                <img alt={merchant.name} style={{width:'40vw'}}
                                     src={merchant.alipay_payment_code_url}/>
                            </div>
                            }
                            {payment_method === BANK_CARD &&
                            <div>
                                <img alt={merchant.name} style={{width:'40vw'}} src={merchant.wechat_url}/>
                                <div style={{marginTop:'5px'}}>商家姓名:<span style={{marginLeft:'20px',fontWeight:'700'}}>{merchant.bank_card_name}</span></div>
                                <div style={{marginTop:'5px'}}>商家卡号:<span style={{marginLeft:'20px',fontWeight:'700'}}>{merchant.bank_card_number}</span></div>
                                <div style={{color:'red',marginTop:'5px'}}>*请与商家确认卡号后再打款！</div>
                            </div>
                            }
                            {payment_method === CASH_ON_DELIVERY &&
                            <div>
                                <img  alt={merchant.name+"微信号"} style={{width:'40vw'}}src={merchant.wechat_url}/>
                            </div>
                            }

                        </div>
                    </div>

                </div>
                <div style={{
                    backgroundColor: 'white',
                    marginTop: '5px',
                    padding: '10px 15px',
                    display: 'flex',
                    alignItems: 'center',
                    flexDirection: 'column'
                }}>
                    <div>订单码</div>
                    <div style={{fontSize: '40px'}}>{order_code}</div>
                </div>
                <div style={{
                    marginTop: '5px',
                    fontSize: this.titleFontSize,
                    backgroundColor: 'white',
                    padding: '10px 15px'
                }}>用餐方式: <span style={{marginLeft: '20px'}}>{dining_method === 'eatIn' ? '堂吃' : '外卖'}</span></div>


                {dining_method === TAKE_AWAY &&
                <div style={{fontSize: this.titleFontSize}}>
                    <div style={{backgroundColor: 'white', marginTop: '5px', padding: '10px 15px'}}>地址信息</div>
                    <div style={{marginTop: '1px', backgroundColor: 'white', padding: '10px 15px'}}>
                        <div>姓名：{address.name}</div>
                        <div style={{marginTop: '5px'}}>电话：{//TODO 可以拨打电话
                            address.phone}</div>
                        <div style={{marginTop: '5px'}}>地址：{address.address}</div>
                        {address.postcode && <div style={{marginTop: '5px'}}>邮编：{address.postcode}</div>}
                    </div>
                </div>
                }

                <div debug={"备注"} style={{marginTop: '5px'}}>
                    <div style={{
                        fontSize: this.titleFontSize,
                        padding: '10px 15px',
                        backgroundColor: 'white'
                    }}>备注: {!comment && <span style={{marginLeft: '20px'}}>无</span>}</div>
                    {comment &&
                    <div style={{marginTop: '1px', padding: '10px 15px', backgroundColor: 'white'}}>{comment}</div>}
                </div>

                <div>
                    <div style={{
                        fontSize: this.titleFontSize,
                        backgroundColor: 'white',
                        marginTop: '5px',
                        padding: '10px 15px'
                    }}>商品列表
                    </div>
                    {
                        orderItems.map(item =>
                            <div key={item.product_id} style={{
                                display: 'flex',
                                flexDirection: 'row',
                                padding: '10px 15px',
                                width: '100%',
                                height: '65px',
                                marginTop: '1px',
                                backgroundColor: 'white'
                            }}>
                                <div style={{
                                    flex: 'none',
                                    width: '75%',
                                    display: 'flex',
                                    flexDirection: 'column',
                                    justifyContent: 'space-between',
                                    height: '100%',
                                    overflow: 'auto'
                                }}>
                                    {//TODO add img
                                    }
                                    <div className='cart_item_title'>{item.product_name}</div>
                                    <div className='cart_item_price'>{item.product_desc}</div>
                                </div>
                                <div style={{
                                    flex: 'none',
                                    width: '25%',
                                    justifyContent: 'flex-end',
                                    display: 'flex',
                                    flexDirection: 'column',
                                    alignItems: 'right',
                                    textAlign: 'right'
                                }}>
                                    <div>{item.uniprice}</div>
                                    <div style={{fontSize: '10px', marginTop: '5px'}}>x{item.quantity}</div>
                                </div>

                            </div>
                        )
                    }
                    <div style={{
                        fontSize: this.titleFontSize,
                        backgroundColor: 'white',
                        marginTop: '1px',
                        padding: '15px',
                        textAlign: 'right'
                    }}>
                        合计: <span style={{fontWeight: '700'}}>{total_price}</span></div>
                </div>

                <div debug={"备注"} style={{
                    backgroundColor: 'white',
                    marginTop: '5px',
                    padding: '15px',
                    fontSize: '12px',
                    marginBottom: '5px'
                }}>
                    <div>订单编号：{order_number}</div>
                    <div style={{marginTop: '15px'}}>下单时间：{create_time}</div>
                    <div style={{marginTop: '15px'}}>付款状态：{status}</div>
                </div>


            </div>


        );
    }
}

function mapStateToProps(state) {
    const {merchant} = state.menuReducer;
    return {merchant};
}

export default withRouter(connect(
    mapStateToProps,
)(OrderComplete));