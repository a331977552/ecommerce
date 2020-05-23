import React from 'react';
import {connect} from "react-redux";
import {bindActionCreators} from "redux";
import './cart.css'
import {updateItemInCartAction,emptyCartAction} from "../data/actions/componentActionCreators";
import CartItem from "./CartItem";
import {
    BrowserRouter,
    Switch,
    Route,
    Link
} from "react-router-dom";

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
    render() {
        const cartItems=Object.values(this.props.cartItems).filter(item => item.count > 0);
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
                    <div style={{display: 'flex', flexDirection: 'row', padding: '10px'}}>
                        <p>已选产品</p>
                        <div style={{flexGrow: '1'}}/>
                        <button onClick={this.onEmptyCartClicked}>清空</button>
                    </div>
                    <div style={{width: '100%', height: '1px', backgroundColor: '#EEEEEE'}}/>
                    <div style={{overflow: 'auto', maxHeight: '400px',minHeight:'0px'}}>
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
                padding: '10px',
                alignItems: 'center',
                flexDirection: 'row'
            }}>

                <div>

                    <button style={{padding: 10}} onClick={this.onCartDetailClick}>查看</button>
                </div>
                <span style={{padding: '10px'}}>{this.props.totalPrice}</span>
                <div style={{flexGrow: '1'}}></div>
                <div>
                    <button style={{padding: 10}} >
                        {this.props.totalPrice === 0? <span>选好了</span>: <Link style={{ textDecoration: 'none' }} disabled={this.props.totalPrice === 0} to={"/stage"}>选好了</Link>}
                       </button>
                </div>
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

export default connect(mapState, mapDispatch)(Cart);