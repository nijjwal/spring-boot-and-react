import {useParams} from 'react-router-dom';

export const withParams = (Component) => props => {
    let params = useParams();
    return <Component  {...props} params={params} />;
}