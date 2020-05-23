import React from "react";
import "./MenuContentItem.css"
import {connect} from 'react-redux'
import {updateItemInCartAction} from '../data/actions/componentActionCreators'

class MenuContentItem extends React.Component {

    onIncreaseClick = (e) => {
        const {product, cartItem} = this.props;
        const result = cartItem.count + 1;
        this.props.updateItemInCar({
            id: cartItem.id,
            count: result > product.quantityRemaining ? cartItem.count : result,
            product
        });
    }

    onDecreaseClick = (e) => {
        const {product, cartItem} = this.props;
        const result = cartItem.count - 1;

        this.props.updateItemInCar({
            id: cartItem.id,
            count: result < 0 ? 0 : result,
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
                    <div style={{display: 'flex', fontSize: '20px'}}>
                        <button style={{width: '35px', height: '35px', fontSize: '14px', fontWeight: '1000'}}
                                onClick={this.onDecreaseClick}>—
                        </button>
                        <div style={{margin: '0px 10px'}}>{cartItem.count}</div>
                        <button style={{width: '40px', height: '35px', fontSize: '20px'}}
                                onClick={this.onIncreaseClick}>+
                        </button>
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
