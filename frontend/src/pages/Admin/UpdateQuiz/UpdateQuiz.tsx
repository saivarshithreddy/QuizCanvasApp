import { useNavigate, useParams } from "react-router-dom";
import PageTitle from "../../../components/PageTitle/PageTitle";
import QuizForm from "../../../components/QuizForm/QuizForm";
import { UPDATE_QUIZ_PAGE_TITLE } from "../../../constants/Constants";
import HttpClient from "../../../services/HttpClient";
import { Quiz } from "../../../models/Quiz";
import ToastService from "../../../services/ToastService";

const UpdateQuiz = () => {

    const { id } = useParams();
    const navigate = useNavigate();

    const handleSubmit = (quiz: Quiz) => {
        HttpClient.put(`/quizzes/${id}`, quiz).then(() => {
            ToastService.success('Quiz mise à jour avec succès');
            navigate('/admin/quiz');
        });
    }
    
    return (
        <>
            <PageTitle value={UPDATE_QUIZ_PAGE_TITLE} />
            <QuizForm id={id} onSubmit={handleSubmit} />
        </>
    );
};

export default UpdateQuiz;