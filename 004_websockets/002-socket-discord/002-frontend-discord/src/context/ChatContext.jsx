import { createContext, useContext, useState } from "react";

const ChatContext = createContext();

export const ChatProvider = ({ children }) => {

  const [roomId, setRoomId] = useState(""); // room of user
  const [currentUser, setCurrentUser] = useState(""); // current user name
  const [connected, setConnected] = useState(false); // is user connected to chat or not

  return (
    <ChatContext.Provider
      value={{
        roomId,
        currentUser,
        connected,
        setRoomId,
        setCurrentUser,
        setConnected,
      }}
    >
      {children}
    </ChatContext.Provider>
  );
};

const useChatContext = () => useContext(ChatContext);
export default useChatContext;
