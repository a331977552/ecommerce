import React from "react";
import {connect} from "react-redux";
import {bindActionCreators} from "redux";
import {onCategorySelected} from "../data/actions/componentActionCreators";
import {theme} from "../utils/ColorUtil";


const categoryItemStyle = {
    width: '100%', flex: 'none',
    padding: '3vw 1vw 3vw 0'
}

const categoryListStyle = {
    overflowY: 'scroll',
    height: '100%',
    width: '100%',
    backgroundColor:theme.leftMenuBackgroundColor
}

class LeftMenuList extends React.Component {

    constructor(props) {
        super(props);
        this.cateRefs = {};
        props.categories.forEach((cate, index) => {
            this.cateRefs[cate.id] = React.createRef();
        })
        this.state = {
            localSelectedIndex: props.categorySelectedIndex
        }
    }

    componentDidUpdate(prevProps, prevState, snapshot) {
        if (prevProps.categorySelectedIndex !== this.props.categorySelectedIndex && this.props.sender !== 'leftlist') {
            this.scrollToView();
        }
    }

    scrollToView = () => {
        this.cateRefs[this.props.categorySelectedIndex].current.scrollIntoView(
            {
                behavior: 'instant',
                block: 'center',
            });

    }
    onCategorySelected = (e, id) => {

        this.props.onCategorySelected({categorySelectedIndex: id, sender: 'leftlist'});
    }

    render() {
        const {props, state} = this;
        return (
            <div style={categoryListStyle}>
                {props.categories.map(category =>
                    <div ref={this.cateRefs[category.id]} key={category.id}
                                                       style={{
                                                           ...categoryItemStyle,
                                                           backgroundColor: props.categorySelectedIndex === category.id ? '#FFFFFF' : ''
                                                       }} onClick={(e) => {this.onCategorySelected(e, category.id)}}>
                        <div style={{
                        borderLeft: props.categorySelectedIndex === category.id ? '2px solid '+theme.primary : '',
                        paddingLeft:props.categorySelectedIndex === category.id ? '2px':'4px'}}>
                        {category.title}
                       </div>
                    </div>)}
            </div>
        )
    }
}


const mapState = (state) => {
    return {categorySelectedIndex: state.menuReducer.categorySelectedIndex, sender: state.menuReducer.sender}
}
const mapDispatch = (dispatch, ownProps) => bindActionCreators({
    onCategorySelected: onCategorySelected
}, dispatch);


export default connect(mapState, mapDispatch)(LeftMenuList);