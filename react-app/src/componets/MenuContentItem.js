import React from "react";
import "./MenuContentItem.css"
import {connect} from 'react-redux'
import plusBtn_svg from '../asserts/icon_circular_mins_btn.svg'
import minsBtn_svg from '../asserts/icon_circular_plus_btn.svg'
import {updateItemInCartAction} from '../data/actions/componentActionCreators'

class MenuContentItem extends React.Component {

    onIncreaseClick = (e) => {
        const {product, cartItem} = this.props;
        const result = cartItem.quantity + 1;
        this.props.updateItemInCar({
            id: cartItem.id,
            quantity: result > product.quantityRemaining ? cartItem.quantity : result,
            product
        });
    }

    onDecreaseClick = (e) => {
        const {product, cartItem} = this.props;
        const result = cartItem.quantity - 1;

        this.props.updateItemInCar({
            id: cartItem.id,
            quantity: result < 0 ? 0 : result,
            product
        });
    }



    render() {
        const {props} = this;
        const {product, cartItem,styles} = this.props;
        return (<div key={product.id} style={{
            width: '100%',
            height: styles.height,
            position: 'relative',
            marginTop:styles.marginTop,
            backgroundColor:'#F5F9FA'
        }}>
            <span className={'menu_item_title'}>{product.name}</span>
            <div style={{position: 'absolute', right: '20px', bottom: '20px'}}>
                {product.quantityRemaining <=0 ?
                    <span style={{backgroundColor: '#FEBB15', padding: '10px 20px', borderRadius: '5px'}}>已售完</span>
                    :
                    <div style={{display: 'flex',alignItems:'center'}}>
                        <img width={'100%'} height={'100%'} src={plusBtn_svg} onClick={this.onDecreaseClick} />
                        <div style={{margin: '0px 10px'}}>{cartItem.quantity}</div>
                        <img width={'100%'} height={'100%'} src={minsBtn_svg} onClick={this.onIncreaseClick}/>
                    </div>
                }
            </div>
            <img style={{height: '100%', width: '100%'}} alt={product.name} src={(product.imgs[0]||{}).url}/>
            <div style={{position: 'absolute', left: '20px', bottom: '20px'}}>￥{product.price}</div>

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


export default connect(null, mapDispatchToProps)(MenuContentItem);
