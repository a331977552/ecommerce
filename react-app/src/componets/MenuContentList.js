import React from "react";
import MenuContentItem from './MenuContentItem';
import './MenuContentList.css';
import {connect} from "react-redux";
import {bindActionCreators} from "redux";
import {onCategorySelected} from "../data/actions/componentActionCreators";

class MenuContentList extends React.Component {
    itemHeight = 200;
    itemMarginTop = 5;
    menuTitleHeight = 50;
    titleMarginTop = 5;

    constructor(props) {
        super(props);
        this.showRunScroll = true;
        this.cateRefs = {};
        this.positionRef= {};
        let cumulativeHeight = 0;
        this.props.categories.forEach((cate,index) => {
            this.cateRefs[cate.id] = React.createRef();
            cumulativeHeight+= cate.products.reduce((totalHeight,cate) => totalHeight+this.itemHeight+this.itemMarginTop, index === 0? this.menuTitleHeight: (this.menuTitleHeight + this.titleMarginTop));
            this.positionRef[cumulativeHeight] = cate.id;
        })
    }


    onMenuScroll = (e) => {
       if(!this.showRunScroll)
       {
           this.showRunScroll = true;
           return ;
       }
        const element = e.target;
        const cumulativeHeights= Object.keys(this.positionRef);
        for (const cumulativeHeight of cumulativeHeights){
            if(element.scrollTop < cumulativeHeight){
                const targetCateId = this.positionRef[cumulativeHeight];
                this.props.onCategorySelected({categorySelectedIndex:targetCateId,sender: 'mentlist'})
                break;
            }
        }
    }

    componentDidUpdate(prevProps, prevState, snapshot) {
        if (prevProps.categorySelectedIndex !== this.props.categorySelectedIndex && this.props.sender !== 'mentlist')
            this.scrollToView();
    }
    componentDidMount() {
        this.scrollToView();
    }
    scrollToView = () => {
        this.cateRefs[this.props.categorySelectedIndex].current.scrollIntoView(
            {
                behavior: 'instant',
                block: 'start',
            });
        this.showRunScroll = false;
    }



    render() {
        if ((this.props.categories || []).length === 0)
            return <div>当前没有菜单</div>
        return <div style={{
            height: '100%',
            width: '100%',
            display: 'flex',
            flexDirection: 'column',
            overflowY:'scroll'
        }}
                    onScroll={this.onMenuScroll}
        >
            {this.props.categories.map((cate, index) =>
                <div key={cate.id} style={{
                    width: '100%',
                    display: 'flex',
                    flexDirection: 'column',
                    marginTop: index === 0 ? 0 : this.titleMarginTop
                }}
                     ref={this.cateRefs[cate.id]}
                >
                    <div className={'menu_title'} style={{height:this.menuTitleHeight}}>{cate.title}{cate.id}</div>
                    {(cate.products || []).map(product => <MenuContentItem styles={{height: this.itemHeight,marginTop:this.itemMarginTop}}
                                                                           key={product.id} product={product}
                                                                           cartItem={this.props.cart.cartItems[product.id]}/>)}
                </div>)}
            <div style={{padding: '15px', textAlign: 'center', width: '100%',height: '8vh'}}>我是有底线的</div>

        </div>
    }
}

const mapState = (state) => {
    return {categorySelectedIndex: state.menuReducer.categorySelectedIndex,sender:state.menuReducer.sender}
}
const mapDispatch = (dispatch, ownProps) => bindActionCreators({
    onCategorySelected: onCategorySelected
}, dispatch);


export default connect(mapState, mapDispatch)(MenuContentList);