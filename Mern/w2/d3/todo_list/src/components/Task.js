import React, { useState } from 'react';

const Task = props => {
    const [label, setLabel] = useState("");
    const [completed, setCompleted] = useState(false);
    const [todoList, setTodoList] = useState([]);

    const createTask = (e) => {
        e.preventDefault();
        setTodoList([
            ...todoList, 
            { title : label, completed : false }
        ]);
        console.log(label);
    };

    const handleTaskClick = (selectedIdx) => {
        const selectedTask = todoList[selectedIdx];
        selectedTask.completed = !selectedTask.completed;
        setTodoList([...todoList])

        /* How to do it without mutating state */
        // const updatedTodos = todoList.map((task, i) => {
        //     if (i === selectedIdx) {
        //         // Replace with brand new item that has new data instead of editing it directly.
        //         return {
        //             ...task,
        //             completed: !task.completed //!task.completed will be the inverse of what it was before
        //         }
        //     }

        //     return task;
        // });

        // setTodoList(updatedTodos);
    }

    return(
        <div>
            <form onSubmit={ createTask }>
                <label>New Task: </label>
                <input type="text" onChange={ (e) => setLabel(e.target.value) } name="item"/>
                <input type="submit" value="Add"></input>
            </form>
            { 
                todoList.map((task, i) => {
                    return <li onClick={ (e) => { handleTaskClick(i) } } key={i}>{ task.title } - { task.completed.toString() }</li>
                })
            }
        </div>
    );
}

export default Task;