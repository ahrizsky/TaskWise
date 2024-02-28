package com.example.bottomsheet;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import androidx.fragment.app.Fragment;


public class ChatFragment extends Fragment {

    private EditText editTextMessage;
    private ImageButton buttonSend;
    private ListView listViewMessages;
    private ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat, container, false);

        editTextMessage = view.findViewById(R.id.messageEditText);
        buttonSend = view.findViewById(R.id.sendMessageButton);
        listViewMessages = view.findViewById(R.id.chatListView);

        // Initialize ArrayAdapter
        adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1);
        listViewMessages.setAdapter(adapter);

        // Set click listener for the send button
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });

        return view;
    }

    private void sendMessage() {
        String message = editTextMessage.getText().toString().trim();
        if (!message.isEmpty()) {
            // Add the new message to the ArrayAdapter
            adapter.add(message);

            // Clear the input field after sending the message
            editTextMessage.setText("");
        }
    }
}
