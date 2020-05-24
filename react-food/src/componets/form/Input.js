import React from "react";

export default function Input(props) {


    return (<div>
            <label style={{display: 'block', width: '100%', marginTop: '5px'}}
                        htmlFor={props.name}>{props.label}</label>
            <input style={{
                display: 'block',
                width: '100%',
                marginTop: '5px',
                fontSize: '14px',
                height: '30px',
                padding: '10px'
            }}
                   {...props}
            />
        </div>
    )
}