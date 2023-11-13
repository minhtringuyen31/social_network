import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  mode: "light",
  user: {
    _id: 1,
    firstName: "Leo",
    lastName: "Messi",
    email: "leomessi@gmail.com",
    phoneNumber: "0111111111",
    profilePicture:
      "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.nydailynews.com%2Fsports%2Fsoccer%2Fny-lionel-messi-world-cup-final-20221218-nca3anmsvjajzkvp2u6ahfpzoi-story.html&psig=AOvVaw1GPtdpw6sz1ClfhubfldvB&ust=1691052454092000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCJjXqbjLvYADFQAAAAAdAAAAABAJ",
    dateOfBrith: "26-06-1987",
  },
  // user: null,
  accessToken: null,
  refreshToken: null,
  posts: [],
};

export const authSlice = createSlice({
  name: "auth",
  initialState,
  reducers: {
    setMode: (state) => {
      state.mode = state.mode === "light" ? "dark" : "light";
    },
    setLogin: (state, action) => {
      state.user = action.payload.user;
      state.accessToken = action.payload.accessToken;
      state.refreshToken = action.payload.refreshToken;
    },
    setLogout: (state) => {
      state.user = null;
      state.accessToken = null;
      state.refreshToken = null;
    },
    setFriends: (state, action) => {
      if (state.user) {
        state.user.friends = action.payload.friends;
      } else {
        console.error("user friends non-existent :(");
      }
    },
    setPosts: (state, action) => {
      state.posts = action.payload.posts;
    },
    setPost: (state, action) => {
      const updatedPosts = state.posts.map((post) => {
        if (post._id === action.payload.post._id) return action.payload.post;
        return post;
      });
      state.posts = updatedPosts;
    },
  },
});

export const { setMode, setLogin, setLogout, setFriends, setPosts, setPost } =
  authSlice.actions;
export default authSlice.reducer;
