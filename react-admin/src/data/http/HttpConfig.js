import axios from 'axios';

const SERVER_ERROR = 500;
const NOT_FOUND = 404;
const FORBIDDEN = 403;
const UNAUTHORIZED = 401;
const REDIRECT = 302;

axios.interceptors.request.use(function (config) {
    const item = localStorage.getItem('token');
    if (item) {
        config.headers.Authorization = `Bearer ${item}`;
    }
    return config;
}, function (error) {
    console.error(error)
    return Promise.reject({message: "未知网络请求异常,请报告管理员"});
});

axios.interceptors.response.use((response) => {
    return Promise.resolve(response);
}, (error) => {
    const response = error.response;
    if (error.response) {
        switch (error.response.status) {
            case SERVER_ERROR:
                return Promise.reject({message: 'server error: ' + 500, response});
            case NOT_FOUND:
                return Promise.reject({message: 'resource not found: ' + 404, response});
            case FORBIDDEN:
                return Promise.reject({message: 'access forbidden: ' + 403, response: response.data});
            case REDIRECT:
                return Promise.reject({message: 'redirected: ' + 302, response});
            case UNAUTHORIZED:
                return Promise.reject({message: 'unauthorized: ' + UNAUTHORIZED, response: response.data});
            default:
                return Promise.reject({message: 'unrecognized error', response});
        }
    } else {
        return Promise.reject({message: "未知网络异常,请报告管理员"});
    }
// axios.defaults.baseURL = 'https://api.example.com';
// axios.defaults.headers.common['Authorization'] = AUTH_TOKEN;
// axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
});
