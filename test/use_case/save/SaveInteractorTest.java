//package use_case.save;
//
//import data_access.TemporaryRecipeDataAccessObject;
//import data_access.SavedRecipeDataAccessObject;
//import org.junit.jupiter.api.Test;
//import use_case.TemporaryRecipeDataAccessInterface;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class SaveInteractorTest {
//    @Test
//    void successTest() {
//
//        SaveInputData saveInputData = new SaveInputData(1);
//        TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessObject = new TemporaryRecipeDataAccessObject(new ArrayList<>());
//        SaveDataAccessInterface saveDataAccessObject = null;
//        try {
//            saveDataAccessObject = new SavedRecipeDataAccessObject();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        SaveOutputBoundary savePresenter = new SaveOutputBoundary() {
//            @Override
//            public void prepareSuccessView(SaveOutputData response) {
//                assertEquals(1, response.getRecipeID());
//            }
//
//            @Override
//            public void prepareFailView(String errorMessage) {
//                fail();
//            }
//        };
//        SaveInteractor saveInteractor = new SaveInteractor(savePresenter, temporaryRecipeDataAccessObject, saveDataAccessObject);
//        saveInteractor.execute(saveInputData);
//    }
//
////    @Test
////    void successTest2(){
////        SaveInputData saveInputData = new SaveInputData(null);
////        TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessObject = new TemporaryRecipeDataAccessObject(new ArrayList<>());
////        SaveDataAccessInterface saveDataAccessObject = null;
////        try {
////            saveDataAccessObject = new SavedRecipeDataAccessObject();
////        } catch (IOException e) {
////            throw new RuntimeException(e);
////        } catch (ClassNotFoundException e) {
////            throw new RuntimeException(e);
////        }
////        SaveOutputBoundary savePresenter = new SaveOutputBoundary() {
////            @Override
////            public void prepareSuccessView(SaveOutputData response) {
////                assertEquals(0, response.getRecipeIdTitle().size());
////            }
////            @Override
////            public void prepareFailView(String errorMessage) {
////                fail();
////            }
////        };
////        SaveInteractor saveInteractor = new SaveInteractor(savePresenter, temporaryRecipeDataAccessObject, saveDataAccessObject);
////        saveInteractor.execute(saveInputData);
////    }
//
//}