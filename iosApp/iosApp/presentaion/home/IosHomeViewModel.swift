//
//  HomeViewModel.swift
//  iosApp
//
//  Created by Muzamil Abdallah on 28/11/1444 AH.
//  Copyright © 1444 AH orgName. All rights reserved.
//

import Foundation
import shared

extension HomeScreen{
    
    @MainActor class  IosHomeViewModel :ObservableObject
    {
        private var dictionaryUseCase:DictionaryUseCase
        private var dictionaryViewModel:DictionaryViewModel
        
        @Published var state:UiState = UiState(error: "", Loading: false, wordDtoItem:[])
        
        private var handle:DisposableHandle?
        
        
        
        init(dictionaryUseCase: DictionaryUseCase ) {
            self.dictionaryUseCase = dictionaryUseCase
            self.dictionaryViewModel = DictionaryViewModel(dictionaryUseCase: dictionaryUseCase, coroutineScope:nil)
            
        }
        
        
        func observe(){
                handle = dictionaryViewModel.state.subscribe(onCollect: { state in
                           if let state = state {
                               self.state = state
                           }
                       })
            
        }
            func doSearch(uiEvent:UiEvent){
                dictionaryViewModel.onEvent(event: uiEvent)
            }
            
            
            func dispose(){
                
                handle?.dispose()
            }
        
    }
}
    
