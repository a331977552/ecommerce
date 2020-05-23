
import axios from 'axios';

const SERVER_ERROR=500;
const NOT_FOUND=404;
const FORBIDDEN=403;
const REDIRECT=302;

axios.interceptors.request.use(function (config) {
    return config;
}, function (error) {
    return Promise.reject(error);
});

axios.defaults.baseURL  = "http://localhost/api"
axios.interceptors.response.use(function (response) {
    if(response.status>=200&&response.status<300){
        return response;
    }else{
        switch (response.status) {
            case SERVER_ERROR:
                return Promise.reject({message:'server error: '+500,response:response});
            case NOT_FOUND:
                return Promise.reject({message:'resource not found: '+404,response:response});
            case FORBIDDEN:
                return Promise.reject({message:'access forbidden: '+403,response:response});
            case REDIRECT:
                return Promise.reject({message:'redirected: '+403,response:response});
            default:
                return  Promise.reject({message:'unrecognized error',response:response});
        }
    }
}, function (error) {
    return Promise.reject(error);
// axios.defaults.baseURL = 'https://api.example.com';
// axios.defaults.headers.common['Authorization'] = AUTH_TOKEN;
// axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
});
