package com.example.projeto_final_recode_android.ui.inserts;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/example/projeto_final_recode_android/ui/inserts/insertCourseViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/projeto_final_recode_android/repository/CourseRepository;", "(Lcom/example/projeto_final_recode_android/repository/CourseRepository;)V", "_courseInsertStateEventData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/projeto_final_recode_android/ui/inserts/insertCourseViewModel$InsertCourseState;", "_messageEventData", "", "insertCourseStateEventData", "Landroidx/lifecycle/LiveData;", "getInsertCourseStateEventData", "()Landroidx/lifecycle/LiveData;", "messageEventData", "getMessageEventData", "addCourse", "Lkotlinx/coroutines/Job;", "name", "", "Companion", "InsertCourseState", "app_debug"})
public final class insertCourseViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.projeto_final_recode_android.repository.CourseRepository repository = null;
    private final androidx.lifecycle.MutableLiveData<com.example.projeto_final_recode_android.ui.inserts.insertCourseViewModel.InsertCourseState> _courseInsertStateEventData = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _messageEventData = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.projeto_final_recode_android.ui.inserts.insertCourseViewModel.Companion Companion = null;
    private static final java.lang.String TAG = null;
    
    public insertCourseViewModel(@org.jetbrains.annotations.NotNull()
    com.example.projeto_final_recode_android.repository.CourseRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.projeto_final_recode_android.ui.inserts.insertCourseViewModel.InsertCourseState> getInsertCourseStateEventData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getMessageEventData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job addCourse(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/example/projeto_final_recode_android/ui/inserts/insertCourseViewModel$InsertCourseState;", "", "()V", "Inserted", "Lcom/example/projeto_final_recode_android/ui/inserts/insertCourseViewModel$InsertCourseState$Inserted;", "app_debug"})
    public static abstract class InsertCourseState {
        
        private InsertCourseState() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/projeto_final_recode_android/ui/inserts/insertCourseViewModel$InsertCourseState$Inserted;", "Lcom/example/projeto_final_recode_android/ui/inserts/insertCourseViewModel$InsertCourseState;", "()V", "app_debug"})
        public static final class Inserted extends com.example.projeto_final_recode_android.ui.inserts.insertCourseViewModel.InsertCourseState {
            @org.jetbrains.annotations.NotNull()
            public static final com.example.projeto_final_recode_android.ui.inserts.insertCourseViewModel.InsertCourseState.Inserted INSTANCE = null;
            
            private Inserted() {
                super();
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/projeto_final_recode_android/ui/inserts/insertCourseViewModel$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}