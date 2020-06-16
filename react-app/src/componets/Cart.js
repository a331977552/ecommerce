import React from 'react';
import {connect} from "react-redux";
import {bindActionCreators} from "redux";
import './cart.css'
import shopping_cart from '../asserts/shopping_cart.svg'
import {updateItemInCartAction, emptyCartAction} from "../data/actions/componentActionCreators";
import CartItem from "./CartItem";
import {withRouter} from "react-router-dom";
import {theme} from "../utils/ColorUtil";


class Cart extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            showCartList: false
        }
    }

    onCartDetailClick = (e) => {
        this.setState({
            showCartList: !this.state.showCartList
        })
    }
    onDismissClicked = (e) => {
        this.setState({
            showCartList: false
        })
    }
    onMenuListCLick = (e) => {
        e.stopPropagation();
    }

    onEmptyCartClicked = (e) => {
        this.props.emptyCart();
        this.setState({
            showCartList: false
        })
    }
    onCheckoutClicked = (e) => {
        this.props.history.push("/stage");

    }

    render() {
        const cartItems = Object.values(this.props.cartItems).filter(item => item.quantity > 0);
        const totalCount = cartItems.reduce((total, item) => total + item.quantity, 0);
        return <div style={{
            backgroundColor: '#FFFFFF',
            width: '100%',
            height: '100%',
            display: 'flex',
            flexDirection: 'column'
        }}>
            {this.state.showCartList &&
            <div className={'cart_item_List'} onClick={this.onDismissClicked}>
                <div style={{flexGrow: 1}}></div>
                <div style={{backgroundColor: '#FFFFFF'}}
                     onClick={this.onMenuListCLick}>
                    <div style={{
                        display: 'flex',
                        flexDirection: 'row',
                        justifyContent: 'space-between',
                        alignItems: 'center',
                        padding: '10px'
                    }}>
                        <div>已选产品</div>
                        <div style={{height: '30px'}}  onClick={this.onEmptyCartClicked}>清空</div>
                    </div>
                    <div style={{width: '100%', height: '1px', backgroundColor: '#EEEEEE'}}/>
                    <div style={{overflow: 'auto', maxHeight: '400px', minHeight: '0px'}}>
                        {
                            cartItems.map(item => <CartItem
                                key={item.product.id} {...item}/>
                            )
                        }
                    </div>

                </div>
            </div>}
            <div style={{
                width: '100%',
                height: '100%',
                display: 'flex',
                justifyContent: 'center',
                boxSizing: 'border-box',

                alignItems: 'center',
                flexDirection: 'row'
            }}>
                <div className={'shopping_cart'}>

                    <img onClick={this.onCartDetailClick} style={{width: '100%', height: '100%'}} src={shopping_cart}/>

                    <div style={{

                        borderRadius: '50%',
                        position: 'absolute',
                        right: '-25px',
                        top: '-15px',
                        backgroundColor: theme.secondary,
                        width: '25px',
                        height: '25px',
                        textAlign: 'center',
                        color: 'white'
                    }}>{totalCount}</div>
                </div>
                <div style={{padding: '10px'}}>{this.props.totalPrice}</div>
                <div style={{flexGrow: '1'}}/>
                <button style={{border:'none',height: '100%', padding: 10, backgroundColor: totalCount === 0?theme.primary_DARK:theme.primary, color: theme.textOnP}}
                        disabled={totalCount === 0} onClick={this.onCheckoutClicked}>
                    去结算
                </button>

            </div>
        </div>
    }

}

const mapState = (state, props) => {
    return state.menuReducer.cart;
};
const mapDispatch = (dispatch, ownProps) => {
    return bindActionCreators({
        updateItemInCar: updateItemInCartAction,
        emptyCart: emptyCartAction
    }, dispatch);

}

export default withRouter(connect(mapState, mapDispatch)(Cart));