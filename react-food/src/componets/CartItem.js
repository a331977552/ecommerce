import React from "react";
import "./MenuContentItem.css"
import {connect} from 'react-redux'
import {updateItemInCartAction} from '../data/actions/componentActionCreators'
import HorizontalLine from "./HorizontalLine";
import    "./CartItem.css";

class CartItem extends React.Component {
    constructor(props) {
        super(props);
    }

    onIncreaseClick = (e) => {
        const {product, count} = this.props;
        console.log(this.props);
        const result = count + 1;

        this.props.updateItemInCar({
            id: product.id,
            count: result > product.quantityRemaining ? count : result,
            product
        });
    }

    onDecreaseClick = (e) => {
        const {product, count} = this.props;
        const result = count - 1;

        this.props.updateItemInCar({
            id: product.id,
            count: result < 0 ? 0 : result,
            product
        });
    }


    render() {
        const {props} = this;
        const {product,count,subPrice} = this.props;
        // const {product, cartItem} = this.props;
        /**
         * count: 3
         id: 159
         subPrice:324
         product: {id: 159, name: "花雕醉龙虾 (小分)1", priceprev1: null, priceprev2: null, price: 118, …}
         updateItemInCar: cartItem => {…}
         *
         */
        return (<div  key={this.props.id} style={{
            width: '100%',
            height: '100px',
        }}>
            <div style={{display:'flex',flexDirection:'row',padding:'15px',width:'100%',height:'99px'}}>
                <div style={{flex:'none',width:'75%',display:'flex',flexDirection:'column',justifyContent:'space-between',height:'100%',overflow:'auto'}}>
                    <p className='cart_item_title'>{product.name}</p>
                    <p className="cart_item_description">{product.description}</p>
                    <p className='cart_item_price'>{subPrice}</p>
                </div>

                <div style={{flex:'none',width:'25%',justifyContent:'flex-end',display:'flex',flexDirection:'row',alignItems:'center'}} >
                    <span className={'cart_item_count_change'} onClick={this.onDecreaseClick}>-</span>
                    <p style={{marginLeft:'5px',marginRight:'5px'}}>{count}</p>
                    <span className={'cart_item_count_change'} onClick={this.onIncreaseClick}>+</span>
                </div>

            </div>
            <HorizontalLine/>
        </div>);

    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        updateItemInCar: cartItem => {
            dispatch(updateItemInCartAction(cartItem))
        }
    }

}


export default connect(null, mapDispatchToProps)(CartItem);
