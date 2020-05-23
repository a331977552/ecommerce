import React from "react";

export  default function withLoadingWrapper(Component) {


    return class extends React.Component {


        constructor(props) {
            super(props);
            console.log(props)
        }

        onRetryClicked = (e) => {
            console.log("onRetryClicked", this.props,e)
        }


        render() {
            const {loading, success} = this.props;
            const {props} = this.props;
            if (!success) {
                if (loading)
                    return <div>loading</div>
                else {
                    return <div>loading failed <button onClick={this.onRetryClicked}>retry</button></div>
                }
            } else
                return <Component {...props} />;
        }


    }
}