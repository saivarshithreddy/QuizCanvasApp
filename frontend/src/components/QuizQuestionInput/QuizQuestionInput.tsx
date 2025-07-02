import styles from './QuizQuestionInput.module.css';
import { ChangeEvent } from 'react';
import { LiaTimesSolid } from "react-icons/lia";
import { QuizQuestion } from '../../models/QuizQuestion';
import { Tooltip } from 'react-tooltip';
import QuizOptionInput from '../QuizOptionInput/QuizOptionInput';
import Input from '../Input/Input';
import Label from '../Label/Label';
import InputError from '../InputError/InputError';
import { QuizQuestionErrors } from '../../services/QuizValidator';
import { QUIZ_OPTIONS, QUIZ_QUESTION, DELETE } from '../../constants/Constants';

type QuizQuestionInputProps = {
    value: QuizQuestion;
    index: number;
    errors: QuizQuestionErrors;
    onChange: (newValue: QuizQuestion, questionIndex: number) => void;
    onRemove: (questionIndex: number) => void;
}

const QuizQuestionInput = ({ value, index, errors, onChange, onRemove }: QuizQuestionInputProps) => {

    const handleQuestionChange = (event: ChangeEvent<HTMLInputElement>) => {
        onChange({...value, question: event.target.value}, index);
    }

    const handleOptionChange = (option: string, optionIndex: number) => {
        const options = value.options;
        options.splice(optionIndex, 1, option);
        onChange({...value, options}, index);
    }

    const handleOptionSelect = (selectedOptionIndex: number) => {
        onChange({...value, answerIndex: selectedOptionIndex}, index);
    }

    return (
        <>
            <div className={[styles.container, errors.isNotEmpty() ? styles.error : ''].join(' ')}>
                <Tooltip id="remove-question" />
                <LiaTimesSolid 
                    data-tooltip-id="remove-question" 
                    data-tooltip-content={DELETE} 
                    className={styles.removeIcon} 
                    onClick={() => onRemove(index)}
                />

                <Input 
                    label={QUIZ_QUESTION}
                    name="question" 
                    value={value.question} 
                    error={errors.question} 
                    onChange={handleQuestionChange}
                />
                <Label>{QUIZ_OPTIONS}</Label>
                <div className={styles.options}>
                    {value.options.map((option, index) => (
                        <QuizOptionInput
                            key={index} 
                            option={option} 
                            optionIndex={index}
                            optionError={errors.options[index]}
                            selectedOptionIndex={value.answerIndex} 
                            onSelect={handleOptionSelect}
                            onChange={handleOptionChange}
                        />
                    ))}
                </div>
            </div>
            <InputError value={errors.answer} />
        </>
    );
}

export default QuizQuestionInput;