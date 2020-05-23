import React from 'react';
import {connect} from "react-redux";
import {bindActionCreators} from "redux";
import {showStage} from "../data/actions/componentActionCreators";
import axios from "axios";
import {Link} from "react-router-dom";
import StageProductItem from "../componets/StageProductItem";

import { withRouter } from 'react-router-dom'
class StagePage extends React.Component {

    constructor(props) {
        super(props);
        console.log(props);
    }

    onDecreaseClick = (item) => {
        const remainingCount = Object.values(this.props.cart.cartItems).reduce((totalCount,item) => totalCount+item.count,0);
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

    }

    /**
     * count: 3
     id: 159
     subPrice:324
     product: {id: 159, name: "花雕醉龙虾 (小分)1", priceprev1: null, priceprev2: null, price: 118, …}
     updateItemInCar: cartItem => {…}
     *
     */
    render() {
        const {loading, success,cart} = this.props;
        const cartItems=Object.values(cart.cartItems).filter(item => item.count > 0);

        if (!success) {
            if (loading)
                return <div>loading<Link to={"/menu"}>go back</Link></div>
            else {
                return <div>loading failed <button onClick={this.onRetryClicked}>retry</button></div>
            }
        } else
            return (
                <div style={{display: 'flex', flexDirection: 'column', backgroundColor: '#EEEEEE'}}>
                    <div style={{
                        display: 'flex',
                        flexDirection: 'column',
                        height: '92vh',
                        overflow: 'scroll',
                        backgroundColor: '#EEEEEE'
                    }}>
                        <div debug={"取餐方式"}>堂吃，外卖</div>

                        <div debug={"送货地址 if 外卖"}>
                            <span>请填写送货地址</span>
                        </div>
                        <div debug={"取货时间提示 if 堂吃"}>
                            1个小时后准备好，
                        </div>
                        <div debug={"支付方式"}>
                            <input type="radio" name="paymentMethod" value="wechat"></input>
                        </div>

                        <div debug={"商品列表"}>
                            {
                                cartItems.map(item=><StageProductItem onDecreaseClick={this.onDecreaseClick} key={item.id} {...item} />
                                )
                            }

                        </div>

                        <div debug={"发票需求"}>如需发票请联系门店索取</div>
                    </div>
                    <div style={{height:'8vh'}}>
                        合计 26 <button>支付</button>
                    </div>

                </div>)

    }

}

const mapState = (state, props) => {
    const {loading, success, cart} = state.menuReducer;
    return {loading, success, cart}
}
const mapDispatch = (dispatch, ownProps) => {
    return bindActionCreators({
        showStage: showStage
    }, dispatch);
}

export default withRouter(connect(mapState, mapDispatch)(StagePage));
