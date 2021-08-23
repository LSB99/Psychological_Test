// import { firestore } from "../../firebase";

const bucket_db = 0

// Actions
const LOAD = "question/LOAD";
const UPDATE = "bucket/UPDATE";
const LOADED = "bucket/LOADED";

const initialState = {
    list: [
        { text: "Q1", completed: false },
        { text: "Q2", completed: false },
        { text: "Q3", completed: false },
    ],
    is_loaded: false,
};

// Action Creators
export const loadBucket = (bucket) => {
    return { type: LOAD, bucket };
};

export const updateBucket = (bucket) => {
    return { type: UPDATE, bucket };
};

export const isLoaded = (loaded) => {
    return { type: LOADED, loaded };
};

export const loadBucketFB = () => {
    return function (dispatch) {
        bucket_db.get().then((docs) => {
            let bucket_data = [];

            docs.forEach((doc) => {
                if (doc.exists) {
                    bucket_data = [...bucket_data, { id: doc.id, ...doc.data() }];
                }
            });

            console.log(bucket_data);

            dispatch(loadBucket(bucket_data));
        });
    };
};

export const updateBucketFB = (bucket) => {
    return function (dispatch, getState) {
        const _bucket_data = getState().bucket.list[bucket];

        let bucket_data = { ..._bucket_data, completed: true };

        if (!bucket_data.id) {
            return;
        }

        bucket_db
            .doc(bucket_data.id)
            .update(bucket_data)
            .then((docRef) => {
                dispatch(updateBucket(bucket));
            })
            .catch((error) => {
                console.log(error);
            });
    };
};



// Reducer
export default function reducer(state = initialState, action = {}) {
    switch (action.type) {
        case "bucket/LOAD": {
            if (action.bucket.length > 0) {
                return { list: action.bucket, is_loaded: true };
            }
            return state;
        }

        case "bucket/UPDATE": {
            const bucket_list = state.list.map((l, idx) => {
                if (idx === action.bucket) {
                    return { ...l, completed: true };
                } else {
                    return l;
                }
            });
            return { list: bucket_list };
        }

        case "bucket/LOADED": {
            return { ...state, is_loaded: action.loaded };
        }

        default:
            return state;
    }
}
