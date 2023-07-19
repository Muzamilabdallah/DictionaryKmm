//
//  HomeScreen.swift
//  iosApp
//
//  Created by Muzamil Abdallah on 28/11/1444 AH.
//  Copyright © 1444 AH orgName. All rights reserved.
//

import SwiftUI
import shared

struct HomeScreen: View {
    @ObservedObject var viewModel: IosHomeViewModel
    private var dictionartyUseCase:DictionaryUseCase
    
    let dictionaryUseCase = UseCaseHelper().getDictionaryUseCase()
    init(dictionartyUseCase: DictionaryUseCase) {
        self.dictionartyUseCase = dictionartyUseCase

        self.viewModel=IosHomeViewModel(dictionaryUseCase:dictionartyUseCase)
    }
    var body: some View {
        VStack {
            Spacer()
            
            
        }
    }
}

 
