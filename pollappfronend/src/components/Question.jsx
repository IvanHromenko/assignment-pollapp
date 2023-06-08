import React, { useState, useEffect } from "react";

const Question = () => {
    const [answerOptions, setAnswerOptions] = useState([]);
    const [selectedOption, setSelectedOption] = useState("");
    const [showProgress, setShowProgress] = useState(false);

    useEffect(() => {
        fetchAnswerOptions();
    }, []);

    const fetchAnswerOptions = () => {
        fetch("http://localhost:8080/api/answer-options")
        .then((response) => response.json())
        .then((data) => {console.log(data);setAnswerOptions(data);})
        .catch((error) => console.log(error));
    };

    const handleOptionChange = (event) => {
        setSelectedOption(event.target.value);
    };

    const handleSubmit = () => {
        fetch(`http://localhost:8080/api/answer-options/${selectedOption}/increment`, {
            method: "POST",
        })
        .then(() => {
            setShowProgress(true);
            fetchAnswerOptions();
        })
        .catch((error) => console.log(error));
    };

    return (
        <div>
            <h2>Please choose your favourite programming language</h2>
            {answerOptions.map((option) => (
                <div key={option.id}>
                    <label>
                        <input
                            type="radio"
                            value={option.id}
                            checked={selectedOption === option.id.toString()}
                            onChange={handleOptionChange}
                        />
                        {option.answerOption}
                    </label>
                </div>
            ))}
            <button onClick={handleSubmit}>Submit</button>
            {showProgress && (
                <div>
                    <h3>Selection Results</h3>
                    {answerOptions.map((option) => (
                        <div key={option.id}>
                            <p>{option.answerOption}</p>
                            <small>{option.numberOfSelections}</small>
                            <progress value={option.numberOfSelections} max="100"></progress>
                        </div>
                    ))}
                </div>
            )}
        </div>
    );
};

export default Question;