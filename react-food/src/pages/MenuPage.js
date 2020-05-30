import React from 'react';
import Carousel from "../componets/Carousel";
import LeftMenuList from "../componets/LeftMenuList";

import MenuContent from "../componets/MenuContentList";
import Cart from "../componets/Cart";

import {connect} from "react-redux";

class MenuPage extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            overflowProps:'scroll'
        }
        this.scrollContentListRef = React.createRef();
        this.scrollParentListRef = React.createRef();
        this.carouselRef = React.createRef();
    }


    onScrollCapture = (e) =>{
        return;
        const element = e.target;
        console.log(e,element,element.scrollTop );
        const carouselHeight = this.carouselRef.current.clientHeight;
        const parentScrolling =  element === this.scrollParentListRef.current;
        if(parentScrolling && element.scrollTop < carouselHeight )
        {
            e.stopPropagation();
            this.setState({overflowProps:'hidden'})
        }else{
            this.setState({overflowProps:'scroll'})
        }
    }


    render() {

        const {categories, cart, loading, success} = this.props;
        if (!success) {
            if (loading)
                return <div>loading</div>
            else {
                return <div>loading failed <button onClick={this.onRetryClicked}>retry</button></div>
            }
        } else
            return (
                <div ref={this.scrollParentListRef}
                     style={{display: 'flex', flexDirection: 'column', height:'100vh', backgroundColor: '#EEEEEE'}}>
                    <div ref={this.carouselRef} style={{height: '20vh', width: '100%', background: 'red' }}>
                        <Carousel/>
                    </div>
                    <div ref={this.scrollContentListRef} style={{height: '74vh', width: '100%', display: 'flex', flexDirection: 'row'}}>
                        <div style={{
                            height: '100%',
                            width: '20vw',
                        }}>
                            <LeftMenuList categories={categories}/>
                        </div>
                        <div style={{
                            height: '100%',
                            width: '80vw',
                        }}>
                            <MenuContent overflowProps={this.state.overflowProps}  categories={categories} cart={cart}/>
                        </div>
                    </div>
                    <div style={{height: '6vh', width: '100%'}}>
                        <Cart/>

                    </div>


                </div>)

    }

}

const mapState = (state, props) => {
    const {loading, success, categories, cart} = state.menuReducer;
    return {loading, success, categories, cart}
}


export default connect(mapState, null)(MenuPage);
